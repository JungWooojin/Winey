package com.team.winey.recommend;


import com.team.winey.recommend.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecommendMapper {
    List<Long> selRecommand(RecommendRes res);
    int insUserinfo(UserinfoDto dto);
    int loginUserPk(LoginUserDto dto);
    List<Integer> selUserinfo(SelRecommendDto dto);
}
