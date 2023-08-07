package com.team.winey.admin.model;

import lombok.Getter;

@Getter
public class OrderListVo {
    private Long orderId;
    private String orderDate;
    private String email;
    private int totalPrice;
    private int payment;
    private String pickUpStore;
}
