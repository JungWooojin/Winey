package com.team.winey.payment.model;

import lombok.Data;

@Data
public class OrderDetailInsDto {
    private int orderId;
    private int productId;
    private int quantity;
}
