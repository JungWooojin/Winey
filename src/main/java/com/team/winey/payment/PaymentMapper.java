package com.team.winey.payment;

import com.team.winey.admin.model.OrderDetailVo;
import com.team.winey.payment.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentMapper {

    int insPayment(PaymentInsDto2 dto2); // 장바구니 결제

    int insEachPayment(EachPaymentInsDto2 dto2); // 개별 결제

    int updBuy(int cartId); // 구매 전후(구매전 0 구매후 1)

    int updPayment(PaymentUpdDto dto); // 카드결제

    int insReview(ReviewInsDto dto); // 리뷰 등록

    int insOrderDetail(OrderDetailInsDto dto); // 와인 하나하나 정보 입력

    List<RegionSelVO> selRegion(RegionInsDto dto); // 픽업지역 출력


}
