package com.team.winey.main;

import ch.qos.logback.core.joran.util.beans.BeanDescriptionFactory;
import com.team.winey.main.model.WineSelDto;
import com.team.winey.main.model.WineTotalVo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@Import( {MainService.class})
@TestPropertySource(properties = {
        "file.dir=/home/download"
})
class MainServiceTest {

    @MockBean
    private MainMapper MAPPER;

    @Autowired
    private MainService SERVICE;

    @Test
    @DisplayName("전체 와인 리스트")
    void selWinePrice() {
        List<WineTotalVo> mockList = new ArrayList<>();
        mockList.add(new WineTotalVo(1L, 1L, 1L, 1L, 1L,
                "트라마리 로제 디 프리미티보", "Tramari Rosé di Primitivo", 11300, 7,
                "wine/1/qMwuRhM3Sl2mHZSfzDwwXg_pb_x960.png", 0, 0, 8,0,0 ));
        mockList.add(new WineTotalVo(2L, 2L, 2L, 2L, 2L,
                "러시아 리버 밸리 피노 누아", "Russian River Valley Pinot Noir", 12000, 11,
                "wine/2/4-vr4iXPT5eVsW46Yi6MnA_pb_x960.png", 0, 0, 10,0,0 ));

        when(MAPPER.selWinePrice()).thenReturn(mockList);

        WineSelDto selDto = new WineSelDto();
        selDto.setPage(1);
        selDto.setStartIdx(1);
        selDto.setRow(2);

        List<WineTotalVo> result = SERVICE.selWine(selDto);
        assertEquals(mockList.size(), result.size());

        for (int i = 0; i < mockList.size(); i++) {
            WineTotalVo ex = mockList.get(i);
            WineTotalVo al = result.get(i);

            assertEquals(ex.getProductId(), al.getProductId(), String.format("%d번 - getProductId 상이", i));
            assertEquals(ex.getCategoryId(), al.getCategoryId(), String.format("%d번 - getCategoryId 상이", i));
            assertEquals(ex.getFeatureId(), al.getFeatureId(), String.format("%d번 - getFeatureId 상이", i));
            assertEquals(ex.getCountryId(), al.getCountryId(), String.format("%d번 - getCountryId 상이", i));
            assertEquals(ex.getAromaId(), al.getAromaId(), String.format("%d번 - getAromaId 상이", i));
            assertEquals(ex.getNmKor(), al.getNmKor(), String.format("%d번 - getNmKor 상이", i));
            assertEquals(ex.getNmEng(), al.getNmEng(), String.format("%d번 - getNmEng 상이", i));
            assertEquals(ex.getPrice(), al.getPrice(), String.format("%d번 - getPrice 상이", i));
            assertEquals(ex.getQuantity(), al.getQuantity(), String.format("%d번 - getQuantity 상이", i));
            assertEquals(ex.getPic(), al.getPic(), String.format("%d번 - getPic 상이", i));
            assertEquals(ex.getPromotion(), al.getPromotion(), String.format("%d번 - getPromotion 상이", i));
            assertEquals(ex.getBeginner(), al.getBeginner(), String.format("%d번 - getBeginner 상이", i));
            assertEquals(ex.getAlcohol(), al.getAlcohol(), String.format("%d번 - getAlcohol 상이", i));
            assertEquals(ex.getSale(), al.getSale(), String.format("%d번 - getSale 상이", i));
            assertEquals(ex.getSalePrice(), al.getSalePrice(), String.format("%d번 - getSalePrice 상이", i));
        }
        verify(MAPPER).selWine(selDto);
    }

    @Test
    void selWineById() {
    }

    @Test
    void selWineByPrice2() {
    }
}