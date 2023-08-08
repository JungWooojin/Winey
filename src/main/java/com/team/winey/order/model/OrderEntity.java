package com.team.winey.order.model;

import lombok.Data;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class OrderEntity {
    private String orderDate;
    private Long orderId;
    private Long userId;
    private String nmKor;
    private int payment;
    private int totalOrderPrice;
    private String storeNm;
    private String pickupTime;
    private int orderStatus;
    private int quantity;


}
