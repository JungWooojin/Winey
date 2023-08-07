package com.team.winey.payment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderDetailSelVo {
    private int orderId;
    private int quantity;
    private int salePrice;
    private int productId;
    private String nmKor;
    private String nmEng;
    private String pic;
}
