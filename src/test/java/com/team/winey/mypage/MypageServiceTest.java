package com.team.winey.mypage;

import com.team.winey.config.security.AuthenticationFacade;
import com.team.winey.config.security.model.MyUserDetails;
import com.team.winey.detail.DetailController;
import com.team.winey.mypage.model.*;
import com.team.winey.sign.model.UserUpdDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.stubbing.OngoingStubbing;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@Import({MypageService.class})
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MypageServiceTest {
    @MockBean
    private AuthenticationFacade facade;
    @MockBean
    private MyPageMapper mapper;

    @Autowired
    private MypageService service;

    @BeforeEach
    void beforeEach() {
        UserDetails user = createUserDetails();
        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities()));
    }
    private UserDetails createUserDetails() {
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_USER");
        //roles.add("ROLE_ADMIN");
        UserDetails userDetails = MyUserDetails.builder()
                .userId(1L)
                .pw("123")
                .roles(roles)
                .build();
        return userDetails;
    }
    @Test
    void updUser() {
        when(mapper.updUser(any())).thenReturn(1);
        UpduserDto dto = new UpduserDto();
        dto.setName("정우진");
        dto.setPw("1234");
        dto.setTel("01044444444");
        dto.setRegionNmId(5L);
        int result = service.updUser(dto);
        assertEquals(1, result);
        verify(mapper).updUser(any());
    }
    @Test
    @DisplayName("유저정보출력")
        //      @WithMockUser(username = "aaa", password = "123")
    void selUser() {
        when(facade.getLoginUserPk()).thenReturn(1L);
        SelUserDto dto = new SelUserDto();
        dto.setUserId(facade.getLoginUserPk());
        SelUserVo vo = new SelUserVo();
        vo.setNm("성수천");
        vo.setDelYn((char) 0);
        vo.setPw("123");
        vo.setUserId(facade.getLoginUserPk());
        vo.setRegionNmId(3L);
        vo.setTel("01077778888");
        SelUserVo vo1 = new SelUserVo();
        when(mapper.selUser(any())).thenReturn(vo);
        SelUserVo result = mapper.selUser(dto);
        assertEquals(vo.getUserId(), result.getUserId());
    }
    @Test
    void delUser() {
        when(facade.getLoginUserPk()).thenReturn(1L);
        when(mapper.delUser(any())).thenReturn(1);
        DelUserDto dto = new DelUserDto();
        dto.setUserId(facade.getLoginUserPk());
        int result = mapper.delUser(dto);
        assertEquals(1, result);
        verify(mapper).delUser(dto);
    }
}


