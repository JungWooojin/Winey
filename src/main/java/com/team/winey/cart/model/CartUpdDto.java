package com.team.winey.cart.model;

import lombok.Data;

@Data
public class CartUpdDto {
    private int cartId; //카트pk
    private int quantity; //수량pk
}
