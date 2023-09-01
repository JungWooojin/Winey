package com.team.winey.payment.model;

import lombok.Data;

@Data
public class PaymentInsDto2 {
    private int orderId; //결제테이블pk
    private Long userId; //유저pk
    private int storeId; //매장pk
    private String pickupTime; //픽업날짜
    private int orderStatus; //주문상태(defaul 0, 픽업상태에 따라 숫자가 변화)
    private int totalOrderPrice; // 총가격
}
