package com.team.winey.mypage;

import com.team.winey.config.security.AuthenticationFacade;
import com.team.winey.mypage.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MypageService {
    private MyPageMapper mapper;
    private AuthenticationFacade facade;
    private PasswordEncoder passwordEncoder;




    public MypageService(MyPageMapper mapper, AuthenticationFacade facade, PasswordEncoder passwordEncoder) {
        this.mapper = mapper;
        this.facade = facade;
        this.passwordEncoder = passwordEncoder;
    }



    public int updUser(UpduserDto dto) {
        UpduserDto2 dto2 = new UpduserDto2();
        dto2.setUserId(facade.getLoginUserPk());
        dto2.setName(dto.getName());
        dto2.setTel(dto.getTel());
        dto2.setPw(passwordEncoder.encode(dto.getPw()));
        dto2.setRegionNmId(dto.getRegionNmId());
        Integer result = mapper.updUser(dto2);
        return result;
    }

//    public SelUserVo selUser(){
//        SelUserDto dto =new SelUserDto();
//        dto.setUserId(facade.getLoginUserPk());
//        return mapper.selUser(dto);
//    }
    public SelUserVo selUser( SelUserDto dto){
        return mapper.selUser(dto);
    }
    public int delUser(){
        DelUserDto dto = new DelUserDto();
        dto.setUserId(facade.getLoginUserPk());
        return mapper.delUser(dto);
    }
}
