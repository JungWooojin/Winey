package com.team.winey.recommend;


import com.team.winey.mypage.model.DelUserDto;
import com.team.winey.recommend.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecommendMapper {
    List<Long> selRecommand(RecommendRes res);
    int insUserinfo(UserinfoDto dto);
    int loginUserPk(LoginUserDto dto);
    List<Integer> selUserinfo(SelRecommendDto dto);
    int delInfo(DelUserDto dto);
    int insRecommand(RecommendRes2 res);
    List<Long> selUserCategoryId(UserDto dto);
    List<Long> selUserCountryId(UserDto dto);
    List<Long> selUserSmallCategoryId(UserDto dto);
    List<Long> selUserPriceRange(UserDto dto);
    AromaVo selUserAroma(UserDto dto);
    int delUserRecommend(DelUserDto dto);


}
