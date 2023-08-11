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
        assertEquals(exresult.getSelPairing().get(0), acresult.getSelPairing().get(0));

        verify(mapper).selWineDetail(any());
//        verify(mapper).selPairing(any());
//        verify(mapper).selCount(any());
//        verify(mapper).selSale(any());
//        verify(mapper).selAroma(any());

        /*
        List<String> selPairing = new ArrayList<>();
        selPairing.add("cheeze");
        selPairing.add("chicken");

        String selCount = "1";

        SelSale selSale = new SelSale();
        selSale.setSale(20);
        selSale.setSalePrice(19838);

        SelWineKorNm korNm = new SelWineKorNm();
        korNm.setProductId(11L);
        korNm.setNmKor("한글이름");
        */



        //assertEquals("cheeze", vo.getSelPairing().get(0));



    }


    @Test
    void selKorNm() {
    }
}
