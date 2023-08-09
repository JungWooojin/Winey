package com.team.winey.recommand;


import com.team.winey.recommand.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecommandMapper {

    List<Integer> selRecommand(RecommandRes res);
    int insUserinfo(UserinfoDto dto);
    List<Integer> selUserinfo(SelRecommandDto dto);
}
