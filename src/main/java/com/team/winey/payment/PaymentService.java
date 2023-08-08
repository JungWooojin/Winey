package com.team.winey.payment;

import com.team.winey.cart.model.CartVo;
import com.team.winey.payment.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentMapper mapper;


    public int insPayment(PaymentInsDto dto){
        PaymentInsDto2 dto2 = new PaymentInsDto2();
        dto2.setUserId(dto.getUserId());
        dto2.setStoreId(dto.getStoreId());
        dto2.setPickupTime(dto.getPickupTime());
        dto2.setOrderStatus(dto.getOrderStatus());

        mapper.insPayment(dto2);


        List<CartVo> list = dto.getList();
        for (CartVo cartVo : list) {
            mapper.updBuy(cartVo.getCartId());
        }

        OrderDetailInsDto d = new OrderDetailInsDto();
        for(int i = 0; i < dto.getList().size(); i++){
            d.setQuantity( dto.getList().get(i).getQuantity());
            d.setProductId(dto.getList().get(i).getProductId());
            d.setOrderId(dto2.getOrderId());
            mapper.insOrderDetail(d);
        }

        return dto2.getOrderId();
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
