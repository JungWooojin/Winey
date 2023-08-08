package com.team.winey.detail.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class WineVo {
    private WineDetailVo wineDetailVo;
    private List<String> selPairing;
    private List<String> selReview;
    private int Level;
    private SelSale selSale;
}
