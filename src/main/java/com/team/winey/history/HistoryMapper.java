package com.team.winey.history;


import com.team.winey.history.model.*;
import com.team.winey.history.model.OrderDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HistoryMapper {

    OrderVo selOrder(OrderDto dto);
    int updPick(UpdPickDto dto);
    ReviewVo selReview(ReviewDto dto);
    RefundVo selRefund(RefundDto dto);




}
