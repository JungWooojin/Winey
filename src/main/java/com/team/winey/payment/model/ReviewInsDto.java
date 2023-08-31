package com.team.winey.payment.model;

import lombok.Data;

@Data
public class ReviewInsDto {
    private int orderDetailId; //주문상세테이블 pk(구매한 제품 각각의 정보를 저장하는 테이블)
    private int reviewLevel; //리뷰(총 3개의 리뷰를 선택할수 있음)
    private Long userId; //유저pk
}
