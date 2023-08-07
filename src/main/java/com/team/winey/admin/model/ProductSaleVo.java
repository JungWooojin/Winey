package com.team.winey.admin.model;

import lombok.Getter;

@Getter
public class ProductSaleVo {
    private Long productId;
    private String nmKor;
    private int price;
    private int sale;
    private int salePrice;
    private int promotion;
    private int beginner;
    private int quantity;
}
