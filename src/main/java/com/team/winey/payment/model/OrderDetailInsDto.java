package com.team.winey.payment.model;

import lombok.Data;

@Data
public class OrderDetailInsDto {
    private int orderId; //결제테이블 pk
    private int productId; //제품pk
    private int quantity; //수량
    private int salePrice; //가격
}
