package com.team.winey.admin.model;

import lombok.Data;

@Data
public class UserOrderDetailDto {
    private Long userId;
    private int startIdx;
    private int row;
    private String type;
    private String sort;
}
