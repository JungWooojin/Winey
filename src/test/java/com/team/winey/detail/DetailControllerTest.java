//package com.team.winey.detail;
//
//import com.team.winey.detail.model.SelAroma;
//import com.team.winey.detail.model.SelSale;
//import com.team.winey.detail.model.WineDetailVo;
//import com.team.winey.detail.model.WineVo;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//
//import java.awt.*;
//import java.util.List;
//import java.util.ArrayList;
//
//import static org.hamcrest.Matchers.hasItem;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.hamcrest.Matchers.hasSize;
//import static org.mockito.Mockito.verify;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//
//@WebMvcTest(DetailController.class)
//@AutoConfigureMockMvc(addFilters = false)
//
//class DetailControllerTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    private DetailService service;
//
//
//    @Test
//    @DisplayName("DetailController - 와인 상세 페이지 Select")
//    void getWineDetail() throws Exception{
//        //given - 테스트 세팅
//        WineDetailVo exdetailVo = new WineDetailVo();
//        exdetailVo.setProductId(11L);
//        exdetailVo.setCategoryNm("레드");
//        exdetailVo.setTemp(2);
//        exdetailVo.setCountryNm("CHILE");
//        exdetailVo.setNmKor("와인한글");
//        exdetailVo.setNmEng("wine영어");
//        exdetailVo.setPrice(99999);
//        exdetailVo.setQuantity(10);
//        exdetailVo.setPic("pic.jpg");
//        exdetailVo.setPromotion(0);
//        exdetailVo.setBeginner(1);
//        exdetailVo.setAlcohol(12);
//        exdetailVo.setSweety(3);
//        exdetailVo.setAcidity(4);
//        exdetailVo.setBody(5);
//
//
//        List<String> exselPairing = new ArrayList<>();
//        exselPairing.add("aaaa");
//        exselPairing.add("bbbb");
//
//        String exselCount = "3";
//        List<String> exselReview = new ArrayList<>();
//        exselReview.add(exselCount);
//
//        SelAroma exaroma = new SelAroma();
//        exaroma.setFlower(1);
//        List<String> exAromaList = new ArrayList<>();
//        exAromaList.add("flower");
//
//        int level = 1;
//
//        SelSale exselSale = new SelSale();
//        exselSale.setProductId(11L);
//        exselSale.setSalePrice(9999);
//        exselSale.setSale(20);
//
//        WineVo mockResult = WineVo.builder()
//                .wineDetailVo(exdetailVo)
//                .selPairing(exselPairing)
//                .selReview(exselReview)
//                .selAroma(exAromaList)
//                .Level(level)
//                .selSale(exselSale)
//                .build();
//
//        given(service.selWineDetail(any())).willReturn(mockResult);
//
//
//        //when - 실제 실행
//        ResultActions ra;
//        ra = mvc.perform(get("/api/detail/11"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.level").value(1))
//                .andExpect(jsonPath("$.wineDetailVo.categoryNm").value("레드"))
//                .andExpect(jsonPath("$.selPairing[0]").value("aaaa"))
//                .andDo(print());
//
//        verify(service).selWineDetail(11L);
//
//
//
//
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    @Test
//    void getWineKorNm() {
//    }
//}