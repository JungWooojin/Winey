package com.team.winey.recommand;


import com.team.winey.config.security.AuthenticationFacade;
import com.team.winey.recommand.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RecommandService {
    private final RecommandMapper mapper;
    private final AuthenticationFacade facade;

    public List<Integer> selRecommand(RecommandRes res) {
        UserinfoDto dto = new UserinfoDto();
        dto.setUserId(facade.getLoginUserPk());
        List<Integer> result = mapper.selRecommand(res);
        dto.setProductId(result);
        mapper.insUserinfo(dto);
        return result;
    }
}
