package com.team.winey.mypage;

import com.team.winey.mypage.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MypageService {
    private final MyPageMapper mapper;

    OrderVo selOrder(OrderDto dto){
        return mapper.selOrder(dto);
    }

    int updPick(UpdPickDto dto){
        return mapper.updPick(dto);
    };





}
