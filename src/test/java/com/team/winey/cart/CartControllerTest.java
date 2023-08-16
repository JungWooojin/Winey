package com.team.winey.cart;

import com.team.winey.cart.model.CartInsDto;
import com.team.winey.cart.model.CartUpdDto;
import com.team.winey.cart.model.CartVo;
import com.team.winey.cart.model.CartdelDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static io.jsonwebtoken.lang.Strings.delete;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(CartController.class)
@AutoConfigureMockMvc(addFilters = false)
class CartControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private CartService service;

    @Test
    void postCart() throws Exception {

        given(service.insCart(any(CartInsDto.class))).willReturn(1);

        CartInsDto dto = new CartInsDto();
        dto.setQuantity(1);
        dto.setProductId(1);

        mvc.perform(MockMvcRequestBuilders.post("/api/wine/cart")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"productId\": 1, \"quantity\": 1}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("1"));

        verify(service).insCart(any());
    }

    @Test
    void getFilledCart() throws Exception {
        List<CartVo> mockList = new ArrayList<>();

        given(service.selCart()).willReturn(mockList);

        mvc.perform(MockMvcRequestBuilders.get("/api/wine/filledcart"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(mockList.size()));
        verify(service).selCart();
    }

    @Test
    void delCart() throws Exception {
        CartdelDto dto = new CartdelDto();
        dto.setCartId(1);

        given(service.delCart(dto)).willReturn(dto.getCartId());

        mvc.perform(MockMvcRequestBuilders.delete("/api/wine/delete")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"cartId\": 1}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("1"));

        verify(service).delCart(dto);

    }

    @Test
    void putCart() throws Exception {
        CartUpdDto dto = new CartUpdDto();
        given(service.updCart(any(CartUpdDto.class))).willReturn(1);

        mvc.perform(MockMvcRequestBuilders.put("/api/wine/quantity")
                        .param("cartId","1")
                        .param("quantity","3"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("1"));

    }
}