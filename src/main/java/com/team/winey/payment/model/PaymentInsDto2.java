package com.team.winey.payment.model;

import lombok.Data;

@Data
public class PaymentInsDto2 {
    private int orderId;
    private int userId;
    private int storeId;
    //    private int cartId;
//    private int payment;
//    private int totalOrderPrice;
    private String pickupTime;
    private int orderStatus;
}
