//package com.team.winey.detail;
//
//import com.team.winey.detail.model.*;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Import;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//
//
//@ExtendWith(SpringExtension.class)
//@Import({DetailService.class})
//class DetailServiceTest {
//    @MockBean
//    private DetailMapper mapper;
//
//    @Autowired
//    private DetailService service;
//
//
//    @Test
//    @DisplayName("DetailService - 와인 상세 페이지 Select")
//    void selWineDetail() {
//        WineDetailVo detailVo = new WineDetailVo();
//        detailVo.setProductId(11L);
//
//        List<String> selPairing = new ArrayList<>();
//        selPairing.add("aaaa");
//        selPairing.add("bbbb");
//
//        SelCountVo selCountVo = new SelCountVo();
//        selCountVo.setProductId(11L);
//        selCountVo.setReviewLevel(1);
//
//        List<String> selReview = new ArrayList<>();
//        selReview.add("0");
//        selReview.add("1");
//        selReview.add("2");
//
//        int level = 1;
//
//        SelSale selSale = new SelSale();
//        selSale.setProductId(11L);
//        selSale.setSalePrice(9999);
//        selSale.setSale(20);
//
//        //when
//        when(mapper.selWineDetail(11L)).thenReturn(detailVo);
//        when(mapper.selPairing(11L)).thenReturn(selPairing);
//        when(mapper.selCount(selCountVo)).thenReturn("1");
//        when(mapper.selSale(11L)).thenReturn(selSale);
//
//        WineVo result = service.selWineDetail(detailVo.getProductId());
//
//        //then
//        assertEquals("cccc", result.getSelPairing().get(0));
//
//
//        /*
//        List<String> selPairing = new ArrayList<>();
//        selPairing.add("cheeze");
//        selPairing.add("chicken");
//
//        String selCount = "1";
//
//        SelSale selSale = new SelSale();
//        selSale.setSale(20);
//        selSale.setSalePrice(19838);
//
//        SelWineKorNm korNm = new SelWineKorNm();
//        korNm.setProductId(11L);
//        korNm.setNmKor("한글이름");
//        */
//
//
//
//        //assertEquals("cheeze", vo.getSelPairing().get(0));
//
//
//
//    }
//
//
//    @Test
//    void selKorNm() {
//    }
//}
