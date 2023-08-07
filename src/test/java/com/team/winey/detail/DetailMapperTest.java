package com.team.winey.detail;

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
        assertEquals(10, vo.getAlcohol());
        assertNotNull(vo.getPic());
        assertEquals("포이약(그랜드 크뤼 클라쎄)", vo.getNmKor());

        WineDetailVo vo2 = mapper.selWineDetail(222L);
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
    }

    @Test
    void selSale() {
    }

    @Test
    void selKorNm() {
    }
}