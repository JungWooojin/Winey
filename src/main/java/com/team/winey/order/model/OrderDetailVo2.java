package com.team.winey.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class OrderDetailVo2 {
    private String orderDate;
    private int payment;
    private String pickupTime;
    private int orderStatus;
    private int totalOrderPrice;
    private String storeNm;

}
