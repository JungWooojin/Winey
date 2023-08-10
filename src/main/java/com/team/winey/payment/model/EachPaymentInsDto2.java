package com.team.winey.payment.model;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class EachPaymentInsDto2 {
    private int productId;
    private Long userId;
    private int orderId;
    private int storeId;
    private int salePrice;
    private int payment;
    private String pickupTime;
    private int quantity;
}
