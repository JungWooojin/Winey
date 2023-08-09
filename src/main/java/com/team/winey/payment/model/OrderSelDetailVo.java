package com.team.winey.payment.model;

import lombok.Data;

@Data
public class OrderSelDetailVo {
    private String orderDate;
    private String nmKor;
    private int totalPrice;
    private int payment;
    private String storeNm;
    private String pickUpTime;
    private int orderStatus;
}
