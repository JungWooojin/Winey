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

    public MypageService(MyPageMapper mapper, AuthenticationFacade facade, PasswordEncoder passwordEncoder) {
        this.mapper = mapper;
        this.facade = facade;
        this.passwordEncoder = passwordEncoder;
    }

    private PasswordEncoder passwordEncoder;
    OrderVo selOrder(OrderDto dto){
        return mapper.selOrder(dto);
    }
    int updPick(UpdPickDto dto){
        return mapper.updPick(dto);
    };


    public int updUser(UpduserDto dto) {
        UpduserDto2 dto2 = new UpduserDto2();
        dto2.setUserId(facade.getLoginUserPk());
        dto2.setName(dto.getName());
        dto2.setTel(dto.getTel());
        dto2.setRegionNmId(dto.getRegionNmId());
        return mapper.updUser(dto2);
    };

    public int updPassword(UpdPasswordDto dto){
        UpdPasswordDto2 dto1=new UpdPasswordDto2();
        dto1.setUserId(facade.getLoginUserPk());
        dto1.setPw(passwordEncoder.encode(dto.getPw()));
        return mapper.updPassword(dto1);
    }
}
