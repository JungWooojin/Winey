package com.team.winey.cart;

import com.team.winey.cart.model.*;
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

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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
        CartSelDto dto = new CartSelDto();
        dto.setUserId(facade.getLoginUserPk());
        when(dto.getUserId()).thenReturn(1l);

        List<CartVo> expectedCartList = new ArrayList<>();
        when(mapper.selCart(any())).thenReturn(expectedCartList);

        List<CartVo> cartList = service.selCart();

        assertEquals(expectedCartList, cartList);
    }

    @Test
    void delCart() {
        CartdelDto dto = new CartdelDto();
        int expectResult = 1;
        when(mapper.delCart(any(CartdelDto.class))).thenReturn(expectResult);

        int result = service.delCart(dto);
        assertEquals(expectResult, result);

        verify(mapper).delCart(any(CartdelDto.class));
    }

    @Test
    void updCart() {
        CartUpdDto dto = new CartUpdDto();
        dto.setCartId(1);
        dto.setQuantity(1);

        when(mapper.updCart(dto)).thenReturn(1);
        int result = service.updCart(dto);

        assertEquals(1,result);
        verify(mapper).updCart(any());
    }
}