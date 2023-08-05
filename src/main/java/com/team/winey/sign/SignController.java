package com.team.winey.sign;

import com.team.winey.sign.model.SignInResultDto;
import com.team.winey.sign.model.SignUpResultDto;
import com.team.winey.utils.EmailValidator;
import com.team.winey.utils.EmailValidator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.team.winey.utils.EmailValidator.emailValidator;

@Tag(name = "회원가입/로그인/로그아웃/refreshtoken관리")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/sign-api")
public class SignController {

    private final SignService SERVICE;
    //ApiParam은 문서 자동화를 위한 Swagger에서 쓰이는 어노테이션이고
    //RequestParam은 http 로부터 요청 온 정보를 받아오기 위한 스프링 어노테이션이다.
    private final EmailValidator emailValidator;

    @PostMapping("/sign-in")
    @Operation(summary = "로그인", description =
            "email : 회원의 이메일(아이디)<br>" +
                    "password: 회원의 비밀번호<br>" +
                    "참고사항 : password 가 틀릴경우 경고창이 나와요<br>" +
                    "참고사항 : 로그인시 액세스 토큰과 리프레시 토큰이 발급되요"
    )

    public SignInResultDto signIn(HttpServletRequest req, @RequestParam String email, @RequestParam String pw) throws Exception {
        String ip = req.getRemoteAddr();
        log.info("[signIn] 로그인을 시도하고 있습니다. email: {}, pw: {}, ip: {}", email, pw, ip);
        return SERVICE.signIn(email, pw, ip);
    }

    @PostMapping("/sign-up")
    @Operation(summary = "회원가입", description =
            "email : 회원의 이메일(아이디)<br>" +
                    "password: 회원의 비밀번호<br>" +
                    "role : 회원의 권한인데 ADMIN(관리자)아니면USER(구매자)만 입력해야합니다요 ex)ADMIN <br>" +
                    "nm : 회원의 이름<br>" +
                    "tel : 전화번호 ex)01051309372 <br>" +
                    "regionNmId : 거주 지역 1:서울특별시, 2:부산광역시, 3:대구광역시, 4:인천광역시, 5:광주광역시, 6:대전광역시, 7:울산광역시, 8:세종특별자치시, 9:경기도, 10:강원특별자치도, 11:충청북도, 12:충청남도, 13:전라북도, 14:전라남도, 15:경상북도, 16:경상남도, 17:제주특별자치도 ex)3  <br>" +
                    "참고사항 : email값에 너무 아무렇게치면 유효성검사규칙에 의해서 회원가입이 안되요. 있을만한 이메일형식으로 등록해야한다요!"
    )

    public SignUpResultDto signUp(@RequestParam String email
            , @RequestParam String pw
            , @RequestParam String role
            , @RequestParam String nm
            , @RequestParam String tel
            , @RequestParam Long regionNmId) {
        log.info("[signUp] 회원가입을 수행합니다. email: {}, pw: {},role: {},nm: {},tel: {},regionNmId: {}", email, pw, role, nm, tel, regionNmId);
        if (!emailValidator(email)) {
            throw new IllegalArgumentException("유효하지 않은 이메일 형식입니다. 유효한 이메일 주소를 입력해주세요.");
        }
        log.info("[signUp] 회원가입 완료 email: {}", email);
        return SERVICE.signUp(email, pw, role, nm, tel, regionNmId);
    }

    @GetMapping("/refresh-token")
    @Operation(summary = "토큰발행", description =
            "refreshToken : 리프레시 토큰을 입력하면 됩니다.<br>" +
                    "참고사항 : 리프레시토큰입력시 액세스토큰이 재발행 됩니다. <br>" +
                    "참고사항 : 로그인이 되어있는 상태에서만 발행이 됩니다."
    )
    public ResponseEntity<SignUpResultDto> refreshToken(HttpServletRequest req
            , @RequestParam String refreshToken) {
        SignUpResultDto dto = SERVICE.refreshToken(req, refreshToken);
        return dto == null ? ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null) : ResponseEntity.ok(dto);
    }

    @PostMapping("/logout")
    @Operation(summary = "로그아웃", description =
            " 기존에 로그인을 하고 있을때만 사용하고, 두번 연속 로그아웃시 에러가 뜹니다요.<br>"
    )
    public ResponseEntity<?> logout(HttpServletRequest req) {
        SERVICE.logout(req);
        ResponseCookie responseCookie = ResponseCookie.from("refresh-token", "")// 프론트엔드에다가 "refresh-token"값으로 저장해주세요 쿠키에 저장해주세요 해야함
                .maxAge(0) // 바로죽이기
                .path("/")
                .build();//저쪽에 쿠키에있는값을 바로 삭제할 수 있게하는 거

        return ResponseEntity
                .status(HttpStatus.OK)
                .header(HttpHeaders.SET_COOKIE, responseCookie.toString())
                .build();
    } //로그아웃

}
