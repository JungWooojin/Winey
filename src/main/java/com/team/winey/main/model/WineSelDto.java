package com.team.winey.main.model;

import lombok.Data;

@Data
public class WineSelDto {
    private Long productId;
    private Long saleYn;
    private int startIdx;
    private int page;
    private int row;

}
