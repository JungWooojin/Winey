//package com.team.winey.mypage;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.team.winey.config.security.model.MyUserDetails;
//import com.team.winey.mypage.model.DelUserDto;
//import com.team.winey.mypage.model.SelUserVo;
//import com.team.winey.mypage.model.UpduserDto;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.ResultMatcher;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.mockStatic;
//import static org.mockito.Mockito.verify;
//import static org.mockito.ArgumentMatchers.any;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@SpringBootTest
//@MockMvcConfig
//class MyPageControllerTest {
//
//
//    @Autowired
//    private MockMvc mvc;// 테스트 단에서 요청보내기
//    @MockBean
//    private MypageService service;
//
//    @Test
//    void putUser() throws Exception {
//            given(service.updUser(any())).willReturn(1);
//
//        UpduserDto dto =new UpduserDto();
//        dto.setPw("123");
//        dto.setTel("01012345678");
//        dto.setRegionNmId(3L);
//        dto.setName("정우진");
//
//        ObjectMapper om =new ObjectMapper();
//        String aa = om.writeValueAsString(dto);
//
//        ResultActions ra =mvc.perform(patch("/api/upduser")
//                .content(aa)
//                .contentType(MediaType.APPLICATION_JSON));
//                     ra.andExpect(status().isOk())
//                        .andExpect(content().string("1"))
//                        .andDo(print());
//        verify(service).updUser(any());
//    }
//
//    @Test
//    void getUser() throws Exception {
//            SelUserVo vo = new SelUserVo();
//            vo.setUserId(1L);
//            vo.setTel("01051309372");
//            vo.setRegionNmId(3L);
//            vo.setDelYn('0');
//            vo.setEmail("wash98@naver.com");
//            vo.setNm("정우진");
////            given(service.selUser()).willReturn(vo);
//        ResultActions ra =mvc.perform(get("/api/userinfo"));
//        ra.andExpect(status().isOk())
//                .andExpect(jsonPath("$.userId").value(1L))
//                .andExpect(jsonPath("$.pw").value("123"))
//                .andExpect(jsonPath("$.tel").value("01051309372"))
//                .andExpect(jsonPath("$.regionNmId").value(3L))
//                .andExpect(jsonPath("$.delYn").value(0))
//                .andExpect(jsonPath("$.email").value("wash98@naver.com"))
//                .andExpect(jsonPath("$.nm").value("정우진"));
////        verify(service).selUser();
//    }
//    @Test
//    void delUser() throws Exception{
//        given(service.delUser()).willReturn(300);
//        DelUserDto dto = new DelUserDto();
//        dto.setUserId(1L);
//
//        ResultActions ra =mvc.perform(delete("/api"));
//                ra.andExpect(status().isOk())
//                        .andExpect(content().string("300"))
//                        .andDo(print());
//                verify(service).delUser();
//    }
//}
//
//
//
