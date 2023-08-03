package com.team.winey.payment.model;

import lombok.Data;

@Data
public class PaymentEntity {
    private int orderId;
    private int userId;
    private int storeId;
    private int productId;
    private int paidYn;
    private int totalQuantity;
    private int totalOrderPrice;
    private String orderDate;
    private int Payment;
    private String pickupTime;
    private int pickupYn;
    private int stockStatus;
}
