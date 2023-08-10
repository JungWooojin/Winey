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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static reactor.core.publisher.Mono.when;

/*

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
    void selWine() {
        WineSelDto dto = new WineSelDto();
        dto.setPage(1);
        dto.setStartIdx(1);
        dto.setRow(9);

        WineTotalVo vo = new WineTotalVo();
        vo.setProductId(1L);
        vo.setCategoryId(1L);
        vo.setFeatureId(1L);
        vo.setCountryId(1L);
        vo.setAromaId(1L);
        vo.setNmKor("트라마리 로제 디 프리미티보");
        vo.setNmEng("Tramari Rosé di Primitivo");
        vo.setPrice(11298);
        vo.setQuantity(7);
        vo.setPic("wine/1/qMwuRhM3Sl2mHZSfzDwwXg_pb_x960.png");
        vo.setPromotion(0);
        vo.setBeginner(0);
        vo.setAlcohol(8);


        List<WineTotalVo> list = new ArrayList<>();
        list.add(vo);

//        when(MAPPER.selWine()).thenReturn(list);

        List<WineTotalVo> serviceList = SERVICE.selWine(dto);

        assertEquals(list.size(), serviceList.size());

        verify(MAPPER).selWine(dto);
    }

    @Test
    void selWineById() {
    }

    @Test
    void selWineByPrice2() {
    }
}

 */