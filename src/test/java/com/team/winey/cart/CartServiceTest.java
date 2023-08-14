package com.team.winey.cart;

import com.team.winey.cart.model.CartInsDto;
import com.team.winey.cart.model.CartInsDto2;
import com.team.winey.config.security.AuthenticationFacade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@Import({CartService.class})

class CartServiceTest {

    @MockBean
    private CartMapper mapper;
    @MockBean
    private AuthenticationFacade facade;


    @Autowired
    private CartService service;

    @Test
    @DisplayName("CartService - Cart 등록")
    void insCart() {
        when(mapper.insCart(any(CartInsDto2.class))).thenReturn(1);

        CartInsDto insDto = new CartInsDto();
        insDto.setProductId(1);
        insDto.setQuantity(1);

        CartInsDto2 dto2 = new CartInsDto2();
        dto2.setQuantity(insDto.getQuantity());
        dto2.setUserId(facade.getLoginUserPk());
        dto2.setProductId(insDto.getProductId());

        int result = service.insCart(insDto);

        assertEquals(0, result);

    }

    @Test
    void selCart() {
    }

    @Test
    void delCart() {
    }

    @Test
    void updCart() {
    }
}