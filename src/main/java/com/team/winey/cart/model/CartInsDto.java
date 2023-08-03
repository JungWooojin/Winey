package com.team.winey.cart.model;

import lombok.Data;

@Data
public class CartInsDto {
    private int quantity;
    private int productId;
    private int userId;
}
