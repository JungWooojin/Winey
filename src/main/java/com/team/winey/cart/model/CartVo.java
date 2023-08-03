package com.team.winey.cart.model;

import lombok.Data;


@Data
public class CartVo {
    private int productId;
    private int quantity;
    private String pic;
    private int salePrice;
    private int price;
    private String nmKor;
    private String nmEng;
}
