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
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DetailMapperTest {
    @Autowired
    private DetailMapper mapper;

    @Test
    void selWineDetail() {
        WineDetailVo vo = mapper.selWineDetail(1L);
        assertEquals(10, vo.getAlcohol());
        assertNotNull(vo.getPic());
        assertEquals("포이약(그랜드 크뤼 클라쎄)", vo.getNmKor());
        assertEquals("Pauillac (Grand Cru Classé)", vo.getNmEng());

        WineDetailVo vo2 = mapper.selWineDetail(222L);
        assertEquals("하라가안 레저바 에스페셜", vo2.getNmKor());
        assertEquals(73196, vo2.getPrice());
        assertEquals("Haragán Reserva Especial", vo2.getNmEng());
    }

    @Test
    void selPairing() {
        List<String> selPairing = mapper.selPairing(1L);
        assertEquals("steak", selPairing.get(0));
        assertEquals("chicken", selPairing.get(1));

        List<String> selPairing2 = mapper.selPairing(100L);
        assertEquals("lamb", selPairing2.get(0));
        assertEquals("cheeze", selPairing2.get(3));
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
        assertEquals("0", result2);

    }

    @Test
    void selSale() {
        SelSale selSale = mapper.selSale(111L);
        assertEquals(10, selSale.getSale());
        assertEquals(10000, selSale.getSalePrice());

        SelSale selSale2 = mapper.selSale(333L);
        assertNull(selSale2);

        SelSale selSale3 = mapper.selSale(222L);
        assertEquals(20, selSale3.getSale());
        assertEquals(22222, selSale3.getSalePrice());

    }

    @Test
    void selKorNm() {
        SelWineKorNm sel = mapper.selKorNm(1L);
        assertEquals("포이약(그랜드 크뤼 클라쎄)", sel.getNmKor());

        SelWineKorNm sel2 = mapper.selKorNm(222L);
        assertEquals("하라가안 레저바 에스페셜", sel2.getNmKor());



    }
}