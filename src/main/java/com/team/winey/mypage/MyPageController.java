package com.team.winey.mypage;

import com.team.winey.mypage.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@Tag(name = "마이페이지")
@RestController
@RequestMapping
@RequiredArgsConstructor
public class MyPageController {
    private final MypageService service;


    @GetMapping("/order")
    @Operation(summary = "결제내역전체출력")
    public OrderVo getOrder(OrderDto dto){
        return service.selOrder(dto);
    }


    @PutMapping("/pick")
    @Operation(summary = "픽업완료처리")
    public int putPick(@RequestParam long orderId){
        UpdPickDto dto = new UpdPickDto();
        dto.setOrderId(orderId);
        return service.updPick(dto);
    }
    @PatchMapping("/upduser")
    public  int putUser(@RequestBody UpduserDto dto){
        return service.updUser(dto);
    }

    @PatchMapping
    public int patchUser(@RequestBody UpdPasswordDto dto){

        return service.updPassword(dto);
    }




}
