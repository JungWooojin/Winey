package com.team.winey.order;

import com.team.winey.order.model.OrderEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
