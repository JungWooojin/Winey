package com.team.winey.recommend;


import com.team.winey.config.security.AuthenticationFacade;
import com.team.winey.recommend.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RecommendService {
    private final RecommendMapper mapper;
    private final AuthenticationFacade facade;

    public List<Long> selRecommand(RecommendRes res) {
        List<Long> result =  mapper.selRecommand(res);
        UserinfoDto dto = new UserinfoDto();
        dto.setUserId(facade.getLoginUserPk());
        dto.setProductId(result);
       mapper.insUserinfo(dto);
        return result;
    }

    List<Integer> selUserinfo(){
        SelRecommendDto dto =new SelRecommendDto();
        dto.setUserId(facade.getLoginUserPk());
        return mapper.selUserinfo(dto);
    }

}
