package com.team.winey.payment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SumPriceSelVo {
    private int userId;
    private int quantity;
    private int price;

}
