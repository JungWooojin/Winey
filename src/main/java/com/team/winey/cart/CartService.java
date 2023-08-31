package com.team.winey.cart;

import com.team.winey.cart.model.*;
import com.team.winey.config.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartMapper mapper;
    private final AuthenticationFacade facade;

    public int insCart(CartInsDto dto) { //장바구니 추가
        CartInsDto2 dto2 = new CartInsDto2();
        dto2.setUserId(facade.getLoginUserPk());
        dto2.setProductId(dto.getProductId());
        dto2.setQuantity(dto.getQuantity());
        mapper.insCart(dto2);
        return dto2.getCartId();
    }

    public List<CartVo> selCart() { //장바구니 출력
        CartSelDto dto = new CartSelDto();
        dto.setUserId(facade.getLoginUserPk());
        return mapper.selCart(dto);
    }

    public int delCart(CartdelDto dto) { //장바구니 삭제
        return mapper.delCart(dto);
    }

    public int updCart(CartUpdDto dto) { //장바구니 업데이트
        return mapper.updCart(dto);
    }
}
