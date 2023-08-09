package com.team.winey.payment.model;

import com.team.winey.cart.model.CartVo;
import lombok.Data;

import java.util.List;

@Data
public class PaymentInsDto {
    private int storeId;
    private String pickupTime;
    private int orderStatus;
    private int totalOrderPrice;
    private List<CartVo> list;
    private QuantityUpdDto quantityUpdDto;
}
