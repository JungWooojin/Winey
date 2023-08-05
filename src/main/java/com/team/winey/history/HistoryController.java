package com.team.winey.history;

import com.team.winey.history.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/history")
@RequiredArgsConstructor
public class HistoryController {
    private final HistoryService service;


    @GetMapping("/order")
    public OrderVo getOrder(OrderDto dto){
        return service.selOrder(dto);
    }


    @PutMapping("/pick")
    public int putPick(@RequestParam long orderId){
        UpdPickDto dto = new UpdPickDto();
        dto.setOrderId(orderId);
        return service.updPick(dto);
    }

    @GetMapping("/review")
    public ReviewVo getReview(ReviewDto dto){
        return service.selReview(dto);
    }

    @GetMapping("/refund")
    public RefundVo getRefund(RefundDto dto){
        return service.selRefund(dto);
    }



}
