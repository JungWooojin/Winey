package com.team.winey.order.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderDetailVo1 {
    private int orderDetailId;
    private String nmKor;
    private String nmEng;
    private int salePrice;
    private int quantity;
    private String pic;
    private String price;
    private int productId;


}
