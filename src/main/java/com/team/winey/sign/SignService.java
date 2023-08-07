package com.team.winey.sign;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.winey.config.CommonRes;
import com.team.winey.config.RedisService;
import com.team.winey.config.security.AuthenticationFacade;
import com.team.winey.config.security.JwtTokenProvider;
import com.team.winey.config.security.UserDetailsMapper;
import com.team.winey.config.security.model.RedisJwtVo;
import com.team.winey.config.security.model.UserEntity;
import com.team.winey.config.security.model.UserTokenEntity;
import com.team.winey.sign.model.SignInResultDto;
import com.team.winey.sign.model.SignUpResultDto;
import com.team.winey.sign.model.UserUpdDto;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SignService {
    private final UserDetailsMapper MAPPER;
    private final JwtTokenProvider JWT_PROVIDER;
    private final PasswordEncoder PW_ENCODER;
    private final RedisService REDIS_SERVICE;
    private final AuthenticationFacade FACADE;
    private final ObjectMapper OBJECT_MAPPER;

    public SignUpResultDto signUp(String email, String pw, String role, String nm,String tel, Long regionNmId) {
        log.info("[getSignUpResult] signDataHandler로 회원 정보 요청");

        UserEntity user = UserEntity.builder()
                .email(email)
                .pw(PW_ENCODER.encode(pw))
                .role(String.format("ROLE_%s", role))
                .name(nm)
                .tel(tel)
                .regionNmId(regionNmId)
                .build();

        int result = MAPPER.save(user);
        SignUpResultDto dto = new SignUpResultDto();

        if(result == 1) {
            log.info("[getSignUpResult] 정상 처리 완료");
            setSuccessResult(dto);
        } else {
            log.info("[getSignUpResult] 실패 처리 완료");
            setFailResult(dto);
        }
        return dto;
    }

    public SignInResultDto signIn(String email, String password, String ip) throws RuntimeException, JsonProcessingException {
        log.info("[getSignInResult] signDataHandler로 회원 정보 요청");
        UserEntity user = MAPPER.getByUid(email);// 이 값이 없으면 아이디가 없는거임
        log.info("[getSignInResult] email: {}", email);

        log.info("[getSignInResult] 패스워드 비교");
        if(!PW_ENCODER.matches(password,user.getPw())) { //암호화되지않은값과 암호화 값이 같은지 비교해주는거
            throw new RuntimeException("비밀번호 다름");
        }
        log.info("[getSignInResult] 패스워드 일치");
        String redisKey = String.format("d:RT(%s):%s:%s", "Server", user.getUserId(), ip);
        if(REDIS_SERVICE.getValues(redisKey) != null) {
            REDIS_SERVICE.deleteValues(redisKey); // 삭제
        }

        log.info("[getSignInResult] access_token 객체 생성");
        String accessToken = JWT_PROVIDER.generateJwtToken(String.valueOf(user.getUserId()), Collections.singletonList(user.getRole()), JWT_PROVIDER.ACCESS_TOKEN_VALID_MS, JWT_PROVIDER.ACCESS_KEY);//여기서 사용할때 스태틱이아니라 . 아인붙고 객체화가 되어있다는거다즉 객체화된 주소가 있다
        String refreshToken = JWT_PROVIDER.generateJwtToken(String.valueOf(user.getUserId()), Collections.singletonList(user.getRole()), JWT_PROVIDER.REFRESH_TOKEN_VALID_MS, JWT_PROVIDER.REFRESH_KEY);
        UserTokenEntity tokenEntity = UserTokenEntity.builder()
                .userId(user.getUserId())
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .ip(ip)
                .build();
        RedisJwtVo redisJwtVo = RedisJwtVo.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
        String value = OBJECT_MAPPER.writeValueAsString(redisJwtVo); //오류가 나서 빵야 함
        REDIS_SERVICE.setValues(redisKey, value);
        int result = MAPPER.updUserToken(tokenEntity); // db에 저장되는 부분 토큰값이 ㅇㅇ

        log.info("[getSignInResult] SignInResultDto 객체 생성");
        SignInResultDto dto = SignInResultDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();

        log.info("[getSignInResult] SignInResultDto 객체 값 주입");
        setSuccessResult(dto);
        return dto;
    }

    public void logout(HttpServletRequest req) {

        String accessToken = JWT_PROVIDER.resolveToken(req, JWT_PROVIDER.TOKEN_TYPE);
        Long iuser = FACADE.getLoginUserPk(); //
        String ip = req.getRemoteAddr();




        // Redis에 저장되어 있는 RT 삭제
        String redisKey = String.format("d:RT(%s):%s:%s", "Server", iuser, ip);//키값은 RT(%s) pk값과 ip값까지 넣었다 레디스에담을 리프레시 토큰에
        String refreshTokenInRedis = REDIS_SERVICE.getValues(redisKey);
        if (refreshTokenInRedis != null) {
            REDIS_SERVICE.deleteValues(redisKey);//있는거면 삭제처리한다.
        }

        // Redis에 로그아웃 처리한 AT 저장
        long expiration = JWT_PROVIDER.getTokenExpirationTime(accessToken, JWT_PROVIDER.ACCESS_KEY) - LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        log.info("date-getTime():{}",new Date().getTime());
        REDIS_SERVICE.setValuesWithTimeout(accessToken, "logout", expiration);  //남은시간 이후가 되면 삭제가 되도록 함.
    }

    public SignInResultDto refreshToken(HttpServletRequest req, String refreshToken) {
        if(!(JWT_PROVIDER.isValidateToken(refreshToken, JWT_PROVIDER.REFRESH_KEY))) {
            return null;
        }

        String ip = req.getRemoteAddr();
        String accessToken = JWT_PROVIDER.resolveToken(req, JWT_PROVIDER.TOKEN_TYPE);
        Claims claims = null;
        try {
            claims = JWT_PROVIDER.getClaims(refreshToken, JWT_PROVIDER.REFRESH_KEY);
        }catch (Exception e) {
            e.printStackTrace();
        }
        if (claims == null) {
            return null;
        }

        String strIuser = claims.getSubject();
        Long iuser = Long.valueOf(strIuser);

        String redisKey = String.format("d:RT(%s):%s:%s", "Server", iuser, ip);
        String value = REDIS_SERVICE.getValues(redisKey); //리프레쉬토큰을 요구했는데  // json 형태의 문자열로 꺼내온다
        if (value == null) { // Redis에 저장되어 있는 RT가 없을 경우 //널이라는건 넣은적이없다
            return null; // -> 재로그인 요청
        }
        try {
            RedisJwtVo redisJwtVo = OBJECT_MAPPER.readValue(value, RedisJwtVo.class);
            if(!redisJwtVo.getAccessToken().equals(accessToken) //헤더에서 꺼내온 액세스토큰이다.
                    || !redisJwtVo.getRefreshToken().equals(refreshToken)) {
                return null;
            }

            List<String> roles = (List<String>)claims.get("roles");
            String reAccessToken = JWT_PROVIDER.generateJwtToken(strIuser, roles, JWT_PROVIDER.ACCESS_TOKEN_VALID_MS, JWT_PROVIDER.ACCESS_KEY);// 새로만든 액세스토큰이다.

            //redis 업데이트 다시 똑같은키값으로 덮어쓰기 하면된다 그럼 새로운 밸류값이 들어가게 된다.
            RedisJwtVo updateRedisJwtVo = RedisJwtVo.builder().accessToken(reAccessToken).refreshToken(redisJwtVo.getRefreshToken()).build();
            String upateValue = OBJECT_MAPPER.writeValueAsString(updateRedisJwtVo);
            REDIS_SERVICE.setValues(redisKey, upateValue);
            return SignInResultDto.builder()
                    .accessToken(reAccessToken)
                    .refreshToken(refreshToken)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public int updSecretKey(Long iuser, String secretKey) {
        UserUpdDto dto = new UserUpdDto();
        dto.setIuser(iuser);
        dto.setSecretKey(secretKey);

        return MAPPER.updSecretKey(dto);
    }

    private void setSuccessResult(SignUpResultDto result) {
        result.setSuccess(true);
        result.setCode(CommonRes.SUCCESS.getCode());
        result.setMsg(CommonRes.SUCCESS.getMsg());
    }

    private void setFailResult(SignUpResultDto result) {
        result.setSuccess(false);
        result.setCode(CommonRes.FAIL.getCode());
        result.setMsg(CommonRes.FAIL.getMsg());
    }
}
