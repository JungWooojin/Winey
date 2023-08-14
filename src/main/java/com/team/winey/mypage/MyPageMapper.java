package com.team.winey.mypage;


import com.team.winey.mypage.model.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyPageMapper {


    int updUser(UpduserDto2 dto2);
    SelUserVo selUser(SelUserDto dto);
    int  delUser(DelUserDto dto);



}
