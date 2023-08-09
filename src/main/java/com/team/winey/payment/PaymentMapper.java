package com.team.winey.payment;

import com.team.winey.payment.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentMapper {

        int insPayment(PaymentInsDto2 dto2);
        int updBuy(int cartId);
        int updPayment(PaymentUpdDto dto);
        //    int selSumPrice(int userId);
        int insReview(ReviewInsDto dto);
        List<OrderDetailSelVo> selOrderDetail(int orderId);
        int insOrderDetail(OrderDetailInsDto dto);
        List<RegionSelVO> selRegion(RegionInsDto dto);
        int updQuantity(QuantityUpdDto dto);

}
