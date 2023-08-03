package com.team.winey.payment;

import com.team.winey.payment.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaymentService {

    private final PaymentMapper mapper;

    @Autowired
    public PaymentService(PaymentMapper mapper){
        this.mapper = mapper;
    }
    public int insPayment(PaymentInsDto dto){
        PaymentInsDto2 dto2 = new PaymentInsDto2();
        dto2.setUserId(dto.getUserId());
        dto2.setStoreId(dto.getStoreId());
        dto2.setCartId(dto.getCartId());
        dto2.setPayment(dto.getPayment());
        dto2.setTotalOrderPrice(dto.getTotalOrderPrice());
        dto2.setPickupTime(dto.getPickupTime());
        dto2.setOrderStatus(dto.getOrderStatus());
        mapper.insPayment(dto2);
        return dto2.getOrderId();
    }

    public int updPayment(PaymentUpdDto dto){
        return mapper.updPayment(dto);
    }



}
