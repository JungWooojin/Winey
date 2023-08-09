package com.team.winey.main;

import com.team.winey.main.MainMapper;
import com.team.winey.main.model.*;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MybatisTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MainMapperTest {

    @Autowired
    private MainMapper MAPPER;

    @Test
    void selWine() {
        WineSelDto selDto = new WineSelDto();
        selDto.setPage(1);
        selDto.setStartIdx(1);
        selDto.setRow(9);
        List<WineTotalVo> list = MAPPER.selWine(selDto);
        assertEquals(9, list.size());

        for (WineTotalVo vo : list) {
            WineSelDetailDto dto = new WineSelDetailDto(vo.getProductId());
            WineTotalVo item = MAPPER.selWineById(dto);

            assertEquals(item.getProductId(), vo.getProductId());
            assertEquals(item.getCategoryId(), vo.getCategoryId());
            assertEquals(item.getFeatureId(), vo.getFeatureId());
            assertEquals(item.getCountryId(), vo.getCountryId());
            assertEquals(item.getAromaId(), vo.getAromaId());
            assertEquals(item.getNmKor(), vo.getNmKor());
            assertEquals(item.getNmEng(), vo.getNmEng());
            assertEquals(item.getPrice(), vo.getPrice());
            assertEquals(item.getQuantity(), vo.getQuantity());
            assertEquals(item.getPic(), vo.getPic());
            assertEquals(item.getPromotion(), vo.getPromotion());
            assertEquals(item.getBeginner(), vo.getBeginner());
            assertEquals(item.getAlcohol(), vo.getAlcohol());
        }

    }

    @Test
    void selWineById() {
        WineSelDetailDto dto = new WineSelDetailDto(1L);
        WineTotalVo vo = MAPPER.selWineById(dto);
        assertEquals(1, dto.getProductId());
        assertEquals(4, vo.getCategoryId());
        assertEquals(470, vo.getFeatureId());
        assertEquals(2, vo.getCountryId());
        assertEquals(470, vo.getAromaId());
        assertEquals("트라마리 로제 디 프리미티보", vo.getNmKor());
        assertEquals("Tramari Rosé di Primitivo", vo.getNmEng());
        assertEquals(11298, vo.getPrice());
        assertEquals(7, vo.getQuantity());
        assertEquals("wine/1/qMwuRhM3Sl2mHZSfzDwwXg_pb_x960.png", vo.getPic());
        assertEquals(0, vo.getPromotion());
        assertEquals(0, vo.getBeginner());
        assertEquals(8, vo.getAlcohol());


        WineSelDetailDto dto2 = new WineSelDetailDto(2L);
        WineTotalVo vo2 = MAPPER.selWineById(dto2);
        assertEquals(2, dto2.getProductId());
        assertEquals(1, vo2.getCategoryId());
        assertEquals(81, vo2.getFeatureId());
        assertEquals(3, vo2.getCountryId());
        assertEquals(81, vo2.getAromaId());
        assertEquals("러시아 리버 밸리 피노 누아", vo2.getNmKor());
        assertEquals("Russian River Valley Pinot Noir", vo2.getNmEng());
        assertEquals(12000, vo2.getPrice());
        assertEquals(11, vo2.getQuantity());
        assertEquals("wine/2/4-vr4iXPT5eVsW46Yi6MnA_pb_x960.png", vo2.getPic());
        assertEquals(0, vo2.getPromotion());
        assertEquals(0, vo2.getBeginner());
        assertEquals(10, vo2.getAlcohol());
    }

    @Test
    void selWineByPrice2() {
        WineSelDto selDto = new WineSelDto();
        selDto.setPage(1);
        selDto.setStartIdx(1);
        selDto.setRow(9);
        List<WineTotalVo> list = MAPPER.selWineByPrice2(selDto);
        assertEquals(9, list.size());

        for (WineTotalVo vo : list) {
            WineSelDetailDto dto = new WineSelDetailDto(vo.getProductId());
            WineTotalVo item = MAPPER.selWineById(dto);
            assertEquals(item.getProductId(), vo.getProductId());
            assertEquals(item.getCategoryId(), vo.getCategoryId());
            assertEquals(item.getFeatureId(), vo.getFeatureId());
            assertEquals(item.getCountryId(), vo.getCountryId());
            assertEquals(item.getAromaId(), vo.getAromaId());
            assertEquals(item.getNmKor(), vo.getNmKor());
            assertEquals(item.getNmEng(), vo.getNmEng());
            assertEquals(item.getPrice(), vo.getPrice());
            assertEquals(item.getQuantity(), vo.getQuantity());
            assertEquals(item.getPic(), vo.getPic());
            assertEquals(item.getPromotion(), vo.getPromotion());
            assertEquals(item.getBeginner(), vo.getBeginner());
            assertEquals(item.getAlcohol(), vo.getAlcohol());
            assertEquals(item.getProductId() < 20000, vo.getPrice() < 20000);
        }
    }


}
