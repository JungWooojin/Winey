package com.team.winey.mypage;


import com.team.winey.mypage.model.*;
import com.team.winey.mypage.model.OrderDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyPageMapper {

    OrderVo selOrder(OrderDto dto);
    int updPick(UpdPickDto dto);
    int updUser(UpduserDto2 dto2);
    SelUserVo selUser(SelUserDto dto);

    int  delUser(DelUserDto dto);



}
