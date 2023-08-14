package com.team.winey.cart;

import com.team.winey.cart.model.*;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@MybatisTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CartMapperTest {

    @Autowired
    private CartMapper mapper;

    @Test
    void insCart() {
        CartInsDto2 dto2 = new CartInsDto2();
        dto2.setUserId(1L);
        dto2.setQuantity(1);
        dto2.setProductId(1);

        int result = mapper.insCart(dto2);
        assertEquals(1,result);
    }

    @Test
    void delCart() {
        int expectResult = 1;
        CartdelDto dto = new CartdelDto();
        dto.setCartId(23);

        int actualResult = mapper.delCart(dto);
        assertEquals(actualResult, expectResult);
    }

    @Test
    void updCart() {
        CartUpdDto dto = new CartUpdDto();
        dto.setQuantity(2);
        dto.setCartId(23);
        int result = mapper.updCart(dto);
        assertEquals(1, result);
    }
}