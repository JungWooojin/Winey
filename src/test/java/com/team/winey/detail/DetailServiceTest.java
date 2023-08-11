package com.team.winey.detail;

import com.team.winey.detail.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@Import({DetailService.class})
class DetailServiceTest {
    @MockBean
    private DetailMapper mapper;

    @Autowired
    private DetailService service;


    @Test
    @DisplayName("DetailService - 와인 상세 페이지 Select")
    void selWineDetail() {
        WineDetailVo exdetailVo = new WineDetailVo();
        exdetailVo.setProductId(11L);

        List<String> exselPairing = new ArrayList<>();
        exselPairing.add("aaaa");
        exselPairing.add("bbbb");

        String exselCount = "3";
        List<String> exselReview = new ArrayList<>();
        exselReview.add(exselCount);


        SelAroma exaroma = new SelAroma();
        exaroma.setFlower(1);
        List<String> exAromaList = new ArrayList<>();
        exAromaList.add("flower");



        int level = 1;

        SelSale exselSale = new SelSale();
        exselSale.setProductId(11L);
        exselSale.setSalePrice(9999);
        exselSale.setSale(20);

        WineVo exresult = WineVo.builder()
                .wineDetailVo(exdetailVo)
                .selPairing(exselPairing)
                .selReview(exselReview)
                .selAroma(exAromaList)
                .Level(level)
                .selSale(exselSale)
                        .build();

        //when
        when(mapper.selWineDetail(any())).thenReturn(exdetailVo);
        when(mapper.selPairing(any())).thenReturn(exselPairing);
        when(mapper.selCount(any())).thenReturn(exselCount);
        when(mapper.selSale(any())).thenReturn(exselSale);
        when(mapper.selAroma(any())).thenReturn(exaroma);

        WineVo acresult = service.selWineDetail(any());

        //then
        assertEquals(exresult.getWineDetailVo().getAlcohol(), acresult.getWineDetailVo().getAlcohol());
        assertEquals(exresult.getSelPairing().get(1), acresult.getSelPairing().get(1));
        assertEquals(exresult.getSelReview().get(0), acresult.getSelReview().get(0));
        assertEquals(exresult.getSelAroma().get(0), acresult.getSelAroma().get(0));
        assertEquals(exresult.getLevel(), acresult.getLevel());
        assertEquals(exresult.getSelSale().getSalePrice(), acresult.getSelSale().getSalePrice());

        verify(mapper).selWineDetail(any());
        verify(mapper).selPairing(any());
        verify(mapper).selSale(any());
        verify(mapper).selAroma(any());

        //verify(mapper).selCount(any());


    }


    @Test
    void selKorNm() {
        SelWineKorNm exnm = new SelWineKorNm();
        exnm.setProductId(4L);
        exnm.setNmKor("와인이당");

        when(mapper.selKorNm(any())).thenReturn(exnm);

        SelWineKorNm acnm = service.selKorNm(any());

        assertEquals(exnm.getProductId(), acnm.getProductId());
        assertEquals("와인이당", acnm.getNmKor());

        verify(mapper).selKorNm(any());



    }
}
