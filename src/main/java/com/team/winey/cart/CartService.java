package com.team.winey.cart;

import com.team.winey.cart.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartMapper mapper;


    public int insCart(CartInsDto dto){
        CartInsDto2 dto2 = new CartInsDto2();
        dto2.setUserId(dto.getUserId());
        dto2.setProductId(dto.getProductId());
        dto2.setQuantity(dto.getQuantity());
        mapper.insCart(dto2);
        return dto2.getCartId();
    }

    public List<CartVo> selCart(CartSelDto dto){

        return mapper.selCart(dto);
    }

    public int delCart(CartdelDto dto){
        return mapper.delCart(dto);
    }
    public int updCart(CartUpdDto dto){
        return mapper.updCart(dto);
    }
//    public int selSumPrice(int userId){
//        return mapper.selSumPrice(userId);
//    }
}
