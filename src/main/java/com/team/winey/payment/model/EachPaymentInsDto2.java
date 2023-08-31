package com.team.winey.payment.model;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class EachPaymentInsDto2 {
    private int productId; //제품pk
    private Long userId; //유저pk
    private int orderId; //결제테이블pk
    private int storeId; //매장pk
    private int salePrice; //가격
    private int payment; //카드결제
    private String pickupTime; //픽업날짜
    private int quantity; //수량
}
