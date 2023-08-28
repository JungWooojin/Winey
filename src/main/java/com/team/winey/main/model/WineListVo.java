package com.team.winey.main.model;

import lombok.Data;

@Data
public class WineListVo {
    private Long productId;
    private String nmKor;
    private String nmEng;
    private int price;
    private String pic;
    private int promotion;
    private int beginner;
    private int sale;
    private int salePrice;
    private int saleYn;
}
