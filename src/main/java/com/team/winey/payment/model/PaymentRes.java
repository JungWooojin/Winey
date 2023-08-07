package com.team.winey.payment.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PaymentRes {
    private PaymentUpdBuyDto buyDto;
    private PaymentInsDto2 dto2;
}
