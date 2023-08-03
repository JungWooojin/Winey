package com.team.winey.cart.model;

import lombok.Data;

@Data
public class CartEntity {
    private int cartId;
    private int userId;
    private int storeWineId;
    private int storeId;
    private int productId;
    private int quantity;
    private String createdAt;
    private String updatedAt;
}
