package com.team.winey.payment;

import com.team.winey.cart.model.CartVo;
import com.team.winey.config.security.AuthenticationFacade;
import com.team.winey.payment.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentMapper mapper;
    private final AuthenticationFacade facade;

    public int insPayment(PaymentInsDto dto){
        PaymentInsDto2 dto2 = new PaymentInsDto2();
        dto2.setUserId(facade.getLoginUserPk());
        dto2.setStoreId(dto.getStoreId());
        dto2.setPickupTime(dto.getPickupTime());
        dto2.setTotalOrderPrice(dto.getTotalOrderPrice());

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
            d.setSalePrice(dto.getList().get(i).getSalePrice());
            mapper.insOrderDetail(d);
        }


        return dto2.getOrderId();
    }
    public int insEachPayment(EachPaymentInsDto dto){
        EachPaymentInsDto2 dto2 = new EachPaymentInsDto2();
        dto2.setUserId(facade.getLoginUserPk());
        dto2.setStoreId(dto.getStoreId());
        dto2.setPickupTime(dto.getPickupTime());
        dto2.setSalePrice(dto.getSalePrice());
        dto2.setPayment(dto.getPayment());
        dto2.setQuantity(dto.getQuantity()); //추가 20230817
        mapper.insEachPayment(dto2);

        OrderDetailInsDto d = new OrderDetailInsDto();
        d.setOrderId(dto2.getOrderId());
        d.setProductId(dto.getProductId());
        d.setQuantity(dto2.getQuantity());
        d.setSalePrice(dto2.getSalePrice());

        mapper.insOrderDetail(d);

        return dto2.getOrderId();
    }

    public int updPayment(PaymentUpdDto dto){
        return mapper.updPayment(dto);
    }

    public int insReview(ReviewInsDto dto){
        dto.setUserId(facade.getLoginUserPk());
        return mapper.insReview(dto);
    }


    public List<RegionSelVO> selRegion(){
        RegionInsDto dto = new RegionInsDto();
        dto.setUserId(facade.getLoginUserPk());

        return mapper.selRegion(dto);
    }


}
