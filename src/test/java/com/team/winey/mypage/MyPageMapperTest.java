package com.team.winey.mypage;

import com.team.winey.detail.DetailService;
import com.team.winey.mypage.model.DelUserDto;
import com.team.winey.mypage.model.SelUserDto;
import com.team.winey.mypage.model.SelUserVo;
import com.team.winey.mypage.model.UpduserDto2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
class MyPageMapperTest {
    @Autowired
    private MyPageMapper mapper;

    @Test
    void updUser() {
        UpduserDto2 dto2=new UpduserDto2();
        dto2.setUserId(1L);
        dto2.setName("정우진");
        dto2.setPw("1234");
        dto2.setTel("01044444444");
        dto2.setRegionNmId(5L);
        int result = mapper.updUser(dto2);
        assertEquals(1,result);
    }

    @Test
    void selUser() {
        SelUserDto dto =new SelUserDto();
        dto.setUserId(1L);
        SelUserVo result = mapper.selUser(dto);
    }

    @Test
    void delUser() {
        DelUserDto dto= new DelUserDto();
        dto.setUserId(1L);
        int result = mapper.delUser(dto);
    }
}