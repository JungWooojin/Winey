package com.team.winey.cart;

import com.team.winey.cart.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {
    int insCart(CartInsDto2 dto2);
    List<CartVo> selCart(CartSelDto dto);
    int delCart(CartdelDto dto);
    int updCart(CartUpdDto dto);
//    int selSumPrice(int userId);
}
