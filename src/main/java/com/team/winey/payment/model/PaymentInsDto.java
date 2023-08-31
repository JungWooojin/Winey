package com.team.winey.payment.model;

import com.team.winey.cart.model.CartVo;
import lombok.Data;

import java.util.List;

@Data
public class PaymentInsDto {
    private int storeId; // 매장 pk 값
    private String pickupTime; // 픽업 날짜
    private int totalOrderPrice; // 총 금액
    private List<CartVo> list; // 카트에 담겨있는 제품의 정보들(카트pk,가격,수량,이름,사진)
}
