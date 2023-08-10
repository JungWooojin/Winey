package com.team.winey.sign;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.winey.config.CommonRes;
import com.team.winey.config.RedisService;
import com.team.winey.config.security.AuthenticationFacade;
import com.team.winey.config.security.JwtTokenProvider;
import com.team.winey.config.security.UserDetailsMapper;
import com.team.winey.config.security.model.SignUpDto;
import com.team.winey.config.security.model.UserEntity;
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

    public SignUpResultDto signUp(SignUpDto dto1) {
        log.info("[getSignUpResult] signDataHandler로 회원 정보 요청");

        UserEntity user = UserEntity.builder()
                .email(dto1.getEmail())
                .pw(PW_ENCODER.encode(dto1.getPw()))
                .role(String.format("ROLE_%s", dto1.getRole()))
                .name(dto1.getNm())
                .tel(dto1.getTel())
                .regionNmId(dto1.getRegionNmId())
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
        REDIS_SERVICE.setValues(redisKey, refreshToken);


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
        String ip = req.getRemoteAddr();

        String redisKey = String.format("d:RT(%s):%s:%s", "Server", iuser, ip);
        String redisRt = REDIS_SERVICE.getValues(redisKey);
        if (redisRt == null) { // Redis에 저장되어 있는 RT가 없을 경우
            return null; // -> 재로그인 요청
        }
        try {
            if(!redisRt.equals(refreshToken)) {
                return null;
            }

            List<String> roles = (List<String>)claims.get("roles");
            String reAccessToken = JWT_PROVIDER.generateJwtToken(strIuser, roles, JWT_PROVIDER.ACCESS_TOKEN_VALID_MS, JWT_PROVIDER.ACCESS_KEY);// 새로만든 액세스토큰이다.


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

