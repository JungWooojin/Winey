package com.team.winey.history.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RefundVo {
    private Long orderId;
    private String refundReason;
    private char refundYn;
    private LocalDateTime refundDate;
}
