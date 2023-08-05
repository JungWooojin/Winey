package com.team.winey.history;

import com.team.winey.history.model.*;
import com.team.winey.history.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HistoryService {
    private final HistoryMapper mapper;

    OrderVo selOrder(OrderDto dto){
        return mapper.selOrder(dto);
    }

    int updPick(UpdPickDto dto){
        return mapper.updPick(dto);
    };


    public ReviewVo selReview(ReviewDto dto){
        return mapper.selReview(dto);
    }

    public RefundVo selRefund(RefundDto dto){
        return mapper.selRefund(dto);
    }

}
