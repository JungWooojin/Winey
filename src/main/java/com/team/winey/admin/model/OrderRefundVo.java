package com.team.winey.admin.model;

import lombok.Getter;

@Getter
public class OrderRefundVo {
    private Long refundId;
    private Long orderId;
    private String refundReason;
    private int refundYn;
    private String refundDate;
}
