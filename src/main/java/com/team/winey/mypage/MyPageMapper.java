package com.team.winey.mypage;


import com.team.winey.mypage.model.*;
import com.team.winey.mypage.model.OrderDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyPageMapper {

    OrderVo selOrder(OrderDto dto);
    int updPick(UpdPickDto dto);




}
