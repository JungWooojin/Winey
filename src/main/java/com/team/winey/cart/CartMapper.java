package com.team.winey.cart;

import com.team.winey.cart.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {
    int insCart(CartInsDto2 dto2); // 장바구니 추가

    List<CartVo> selCart(CartSelDto dto); // 장바구니 출력

    int delCart(CartdelDto dto); // 장바구니 삭제

    int updCart(CartUpdDto dto); //장바구니 수량변경

}
