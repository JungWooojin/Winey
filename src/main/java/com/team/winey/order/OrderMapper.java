package com.team.winey.order;

import com.team.winey.order.model.OrderCancelDto;
import com.team.winey.order.model.OrderEntity;
import com.team.winey.order.model.OrderIdCountDto;
import com.team.winey.order.model.OrderPickupFinishDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<OrderEntity> selOrder(OrderIdCountDto dto);
    int selOrderCountByUser(OrderIdCountDto dto);
    int selOrderIdMax(Long userId);

    List<OrderIdCountDto> selOrderCheck(Long userId);

    int cancelOrder(Long orderId);

    int pickupFinishOrder(Long orderId);



}
