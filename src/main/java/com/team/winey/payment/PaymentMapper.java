package com.team.winey.payment;

import com.team.winey.payment.model.PaymentInsDto2;
import com.team.winey.payment.model.PaymentUpdDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper {
    int insPayment(PaymentInsDto2 dto2);
    int updPayment(PaymentUpdDto dto);
}
