package com.team.winey.history.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class OrderVo {
    private LocalDateTime orderDate;
    private Long productId;
    private Long orderId;
    private String nmKor;
    private Long orderDetailId;
    private Long payment;
    private Long salePrice;
    private char orderStatus;
}
