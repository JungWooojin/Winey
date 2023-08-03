package com.team.winey.main.model;

import lombok.Data;

@Data
public class WineVo {
    public Long categoryId;
    public Long featureId;
    public Long countryId;
    public Long aromaId;
    private String nmKor;
    private String nmEng;
    private int price;
    private int quantity;
    private String pic;
    private int promotion;
    private int beginner;
    private int alcohol;

}
