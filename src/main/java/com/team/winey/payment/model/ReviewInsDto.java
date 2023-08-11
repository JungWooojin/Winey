package com.team.winey.payment.model;

import lombok.Data;

@Data
public class ReviewInsDto {
    private int orderDetailId;
    private int reviewLevel;
    private Long userId;
}
