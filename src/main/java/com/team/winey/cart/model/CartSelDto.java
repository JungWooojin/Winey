package com.team.winey.cart.model;

import lombok.Data;

@Data
public class CartSelDto {
    private int cartId;
    private int userId;
    private int productId;
    private String nmKor;
    private String nmEng;
    private int price;
    private int salePrice;
    private String pic;
    private int quantity;
}
