package com.team.winey.detail;

import com.team.winey.detail.model.SelCountVo;
import com.team.winey.detail.model.SelSale;
import com.team.winey.detail.model.SelWineKorNm;
import com.team.winey.detail.model.WineDetailVo;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
//@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DetailMapperTest {
    @Autowired
    private DetailMapper mapper;

    @Test
    void selWineDetail() {
        WineDetailVo vo = mapper.selWineDetail(1L);
        assertEquals(8, vo.getAlcohol());
        assertNotNull(vo.getPic());
        assertEquals("트라마리 로제 디 프리미티보", vo.getNmKor());

        WineDetailVo vo2 = mapper.selWineDetail(222L);
        assertEquals(48981, vo2.getPrice());
        assertEquals("Stonehorse Shiraz", vo2.getNmEng());
    }

    @Test
    void selPairing() {
        List<String> selPairing = mapper.selPairing(1L);
        assertEquals("fruit", selPairing.get(0));
        assertEquals("steak", selPairing.get(1));

        List<String> selPairing2 = mapper.selPairing(100L);
        assertEquals("cheeze", selPairing2.get(0));
        assertEquals("lamb", selPairing2.get(3));
    }

    @Test
    void selCount() {
        SelCountVo vo = new SelCountVo();
        vo.setProductId(11L);
        vo.setReviewLevel(1);
        String result = mapper.selCount(vo);
        assertEquals("0", result);

        SelCountVo vo2 = new SelCountVo();
        vo2.setProductId(11L);
        vo2.setReviewLevel(0);
        String result2 = mapper.selCount(vo2);
        assertEquals("1", result2);

    }

    @Test
    void selSale() {
        SelSale selSale = mapper.selSale(58L);
        assertEquals(10, selSale.getSale());
        assertEquals(19838, selSale.getSalePrice());

        SelSale selSale2 = mapper.selSale(10L);
        assertNull(selSale2);

        SelSale selSale3 = mapper.selSale(485L);
        assertEquals(10, selSale3.getSale());
        assertEquals(198000, selSale3.getSalePrice());

    }

    @Test
    void selKorNm() {
        SelWineKorNm sel = mapper.selKorNm(1L);
        assertEquals("트라마리 로제 디 프리미티보", sel.getNmKor());

        SelWineKorNm sel2 = mapper.selKorNm(222L);
        assertEquals("스톤호스 시라즈(Stonehorse Shiraz", sel2.getNmKor());



    }
}