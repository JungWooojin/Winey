package com.team.winey.order;

import com.team.winey.order.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<OrderEntity> selOrder(UserIdDto dto);

    int cancelOrder(OrderCancelDto dto);
    int pickupFinishOrder(OrderPickupFinishDto dto);

    List<OrderDetailVo1> selOrderDetail1(UserIdDto dto);
    OrderDetailVo2 selOrderDetail2(UserIdDto dto);




}
