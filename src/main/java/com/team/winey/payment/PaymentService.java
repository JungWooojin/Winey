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

    public int insPayment(PaymentInsDto dto){ // t_order에 인서트가 되는 동시에 t_cart 컬럼 buy_yn 1로 바뀌고 t_order_detail 에 리스트하나하나의 가격과 수량이 담긴다
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
    public int insEachPayment(EachPaymentInsDto dto){ //개별 구매
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

    public int updPayment(PaymentUpdDto dto){ //카드 결제 update
        return mapper.updPayment(dto);
    }

    public int insReview(ReviewInsDto dto){ // 리뷰 등록
        dto.setUserId(facade.getLoginUserPk());
        int reviewInsert = mapper.insReview(dto);
        if(reviewInsert >0){
            return 1;
        }else{
            return 0;
        }
    }

    public List<RegionSelVO> selRegion(){ // 픽업 지역 출력
        RegionInsDto dto = new RegionInsDto();
        dto.setUserId(facade.getLoginUserPk());

        return mapper.selRegion(dto);
    }

}
