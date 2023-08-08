package com.team.winey.recommand;


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


    public List<Integer> selRecommand(RecommandRes res){
        return mapper.selRecommand(res);
    }
}
