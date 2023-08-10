package com.team.winey.payment.model;

import lombok.Data;

@Data
public class EachPaymentInsDto {
    private int productId;
    private int storeId;
    private int salePrice;
    private int payment;
    private String pickupTime;
    private int quantity;
}