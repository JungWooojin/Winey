package com.team.winey.recommend;


import com.team.winey.recommend.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecommendMapper {
    List<Long> selRecommend(RecommendRes res);
    int insUserinfo(UserinfoDto dto);
    int loginUserPk(UserDto dto);
    List<Integer> selUserinfo(SelRecommendDto dto);
    int insRecommend(InsRecommend res);
    List<Long> selUserCategoryId(UserDto dto);
    List<Long> selUserCountryId(UserDto dto);
    List<Long> selUserSmallCategoryId(UserDto dto);
    List<Long> selUserPriceRange(UserDto dto);
    List<Long> selUserAroma(UserDto dto);
    int delUserRecommend(UserDto dto);
    int delInfo(UserDto dto);


}
