package com.team.winey.order;

import com.team.winey.order.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<OrderEntity> selOrder(UserIdDto dto);

    int cancelOrder(Long orderId);
    int pickupFinishOrder(Long orderId);

    List<OrderDetailVo1> selOrderDetail1(Long orderId);
    OrderDetailVo2 selOrderDetail2(Long orderId);




}
