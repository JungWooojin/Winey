package com.team.winey.admin.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserOrderDetailVo {
    private Long orderId;
    private Long orderDetailId;
    private String orderDate;
    private String nmKor;
    //    private int totalOrderPrice; //최종결제금액
    private int quantity;
    private int price; //최종결제금액
    private String storeNm; //픽업지점이름
    private int orderStatus; //주문상태
}
