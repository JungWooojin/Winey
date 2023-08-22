package com.team.winey.mypage;

import com.team.winey.config.security.model.MyUserDetails;
import com.team.winey.mypage.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@Tag(name = "마이페이지")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MyPageController {
    private final MypageService service;


    @PatchMapping("/upduser")
    @Operation(summary = "회원정보수정", description =
            "주의사항: 로그인되어있을때 사용하셔야합니다. <br>"
            )
    public  int putUser(@RequestBody UpduserDto dto){
        return service.updUser(dto);
    }

    @GetMapping("/userinfo")
    @Operation(summary = "로그인한사람의 회원정보",description =
            "주의사항: 로그인되어있을때 사용하셔야합니다. delYn값이 0이여야합니다. 1이면 삭제처리유저입니다. <br>")
    public SelUserVo getUser(@AuthenticationPrincipal MyUserDetails details){
        SelUserDto dto = new SelUserDto();
        dto.setUserId(details.getUserId());
        return service.selUser(dto);
    }



    @DeleteMapping("/delUser")
    @Operation(summary = "유저 삭제 처리",description =
            "주의사항: 로그인되어있을때 사용하셔야합니다. delYn이 0에서 1로 삭제처리로 바꾸는 작업입니다.<br>")
    public int delUser(){
        return service.delUser();
    }
}



