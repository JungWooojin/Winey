package com.team.winey.main.model;

import lombok.Data;

@Data
public class WineVo {
    private Long productId;
    private Long categoryId;
    private Long featureId;
    private Long countryId;
    private Long aromaId;
    private String nmKor;
    private String nmEng;
    private int price;
    private int quantity;
    private String pic;
    private int promotion;
    private int beginner;
    private int alcohol;

}
