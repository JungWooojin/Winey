package com.team.winey.payment;

import com.team.winey.payment.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentMapper mapper;


    public PaymentRes insPayment(PaymentInsDto dto){
        PaymentInsDto2 dto2 = new PaymentInsDto2();
        dto2.setUserId(dto.getUserId());
        dto2.setStoreId(dto.getStoreId());
//        dto2.setCartId(dto.getCartId());
//        dto2.setPayment(dto.getPayment());
//        dto2.setTotalOrderPrice(dto.getTotalOrderPrice());
        dto2.setPickupTime(dto.getPickupTime());
        dto2.setOrderStatus(dto.getOrderStatus());
        mapper.insPayment(dto2);

        PaymentUpdBuyDto buyDto = new PaymentUpdBuyDto();
        buyDto.setCartId(dto.getCartId());
        buyDto.setUserId(dto2.getUserId());
        mapper.updBuy(buyDto);

        return PaymentRes.builder()
                .buyDto(buyDto)
                .build();
    }

    public int updPayment(PaymentUpdDto dto){
        return mapper.updPayment(dto);
    }
    public int selSumPrice(int userId){
        return mapper.selSumPrice(userId);
    }
    public int insReview(ReviewInsDto dto){
        return mapper.insReview(dto);
    }
    public List<OrderDetailSelVo> selOrderDetail(int orderId){
        return mapper.selOrderDetail(orderId);
    }


}
