package com.team.winey.detail.model;

import lombok.Data;

@Data
public class WineDetailVo {
    private Long productId;
    private String categoryNm;
    private int temp;
    private String countryNm;
    private String nmKor;
    private String nmEng;
    private int price;
    private int quantity;
    private String pic;

    private int promotion;
    private int beginner;

    private int alcohol;
    private int sweety;
    private int acidity;
    private int body;

    private int flower;
    private int plant;
    private int fruit;
    private int spicy;
    private int earth;
    private int oak;
    private int nuts;

}
