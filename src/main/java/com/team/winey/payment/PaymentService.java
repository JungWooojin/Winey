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

    public int insPayment(PaymentInsDto dto){ //t_order에 인서트(결제테이블)
        PaymentInsDto2 dto2 = new PaymentInsDto2();
        dto2.setUserId(facade.getLoginUserPk());
        dto2.setStoreId(dto.getStoreId());
        dto2.setPickupTime(dto.getPickupTime());
        dto2.setTotalOrderPrice(dto.getTotalOrderPrice());

        mapper.insPayment(dto2);


        List<CartVo> list = dto.getList();  //t_cart 컬럼 buy_yn의 default가 0인데 1로 결제하는 순간 1로 바뀐다
        for (CartVo cartVo : list) {
            mapper.updBuy(cartVo.getCartId());
        }

        OrderDetailInsDto d = new OrderDetailInsDto(); //결제한 제품 하나하나의 정보(수량,가격 등등) 이 저장된다.
        for(int i = 0; i < dto.getList().size(); i++){
            d.setQuantity( dto.getList().get(i).getQuantity());
            d.setProductId(dto.getList().get(i).getProductId());
            d.setOrderId(dto2.getOrderId());
            d.setSalePrice(dto.getList().get(i).getSalePrice());
            mapper.insOrderDetail(d);
        }


        return dto2.getOrderId();
    }
    public int insEachPayment(EachPaymentInsDto dto){ //개별 구매(와인상세페이지에서 장바구니에 안넣고 구매하기버튼을 누른경우)
        EachPaymentInsDto2 dto2 = new EachPaymentInsDto2();
        dto2.setUserId(facade.getLoginUserPk());
        dto2.setStoreId(dto.getStoreId());
        dto2.setPickupTime(dto.getPickupTime());
        dto2.setSalePrice(dto.getSalePrice());
        dto2.setPayment(dto.getPayment());
        dto2.setQuantity(dto.getQuantity()); //추가 20230817
        mapper.insEachPayment(dto2);

        OrderDetailInsDto d = new OrderDetailInsDto(); //구매한 제품의 정보가 담긴다.
        d.setOrderId(dto2.getOrderId());
        d.setProductId(dto.getProductId());
        d.setQuantity(dto2.getQuantity());
        d.setSalePrice(dto2.getSalePrice());

        mapper.insOrderDetail(d);

        return dto2.getOrderId();
    }

    public int updPayment(PaymentUpdDto dto){ //카드 결제(default 값이 0 인데 1로 바뀐다)
        return mapper.updPayment(dto);
    }

    public int insReview(ReviewInsDto dto){ // 리뷰 등록(등록되면 1 아니면 0 리턴)
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
