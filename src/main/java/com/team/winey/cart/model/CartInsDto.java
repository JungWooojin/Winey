package com.team.winey.cart.model;

import lombok.Data;

@Data
public class CartInsDto {
    private int quantity; //수량
    private int productId; //제품pk
}
