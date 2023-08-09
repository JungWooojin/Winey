package com.team.winey.order;

import com.team.winey.order.model.OrderCancelDto;
import com.team.winey.order.model.OrderEntity;
import com.team.winey.order.model.OrderPickupFinishDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "주문내역 페이지")
@RestController
@RequestMapping("/orderList")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService service;

    @GetMapping("/{userId}")
    @Operation(summary = "유저별 주문내역 리스트", description =
            "")
    public List<OrderEntity> selOrder(@PathVariable Long userId){


        return service.selOrder(userId);
    }

    @PutMapping("/cancel")
    @Operation(summary = "주문 취소", description = "주문상태를 주문 취소로 업데이트")
    public int cancelOrder(@RequestParam Long orderId) {
        return service.cancelOrder(orderId);
    }

    @PutMapping("/pickupFinish")
    @Operation(summary = "픽업 완료", description = "주문상태를 픽업완료로 업데이트")
    public int pickupFinishOrder(@RequestParam Long orderId){
        return service.pickupFinishOrder(orderId);
    }



}
