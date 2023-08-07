package com.team.winey.admin.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductVo {
    private Long productId;
    private String nmKor;
    private int price;
    private int promotion;
    private int beginner;
    private int quantity;
}
