package com.team.winey.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.winey.MockMvcConfig;
import com.team.winey.admin.model.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*; //mvc.perform(get/post 이런거)
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Slf4j
@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(AdminController.class)
@MockMvcConfig
class AdminControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AdminService service;

    @Test
    void postProduct() throws Exception {
        //given
        ProductInsParam p = new ProductInsParam();
        p.setNmKor("한글이름");
        p.setNmEng("EngName");
        p.setPrice(10000);
        p.setPromotion(1);
        p.setBeginner(1);
        p.setAlcohol(10);
        p.setQuantity(100);

        p.setCountry(1);
        p.setSweety(1);
        p.setAcidity(2);
        p.setBody(3);

        p.setCategory(1);

        ProductAromaParam aroma = new ProductAromaParam();
        aroma.setEarth(1);
        aroma.setOak(1);
        aroma.setNuts(0);
        aroma.setPlant(0);
        aroma.setFruit(0);
        aroma.setFlower(1);
        aroma.setSpicy(0);

        p.setAroma(aroma);

        p.setSale(10);
        p.setSalePrice(9000);
        p.setStartSale("2023-08-08 00:00");
        p.setEndSale("2023-08-09 00:00");

        List<Integer> smallCategoryId = new ArrayList<>();
        smallCategoryId.add(1);
        smallCategoryId.add(2);
        p.setSmallCategoryId(smallCategoryId);

        MultipartFile pic = null;
        ProductInsParam param = new ProductInsParam();
        given(service.postProduct(pic, p)).willReturn(1);

        String originalFileNm = "14cf6643-a057-4933-a6df-43944faf7668";
        String contentType = "png";
        String filePath = "D:/home/download/winey/product/1477/" + originalFileNm + "." + contentType;
        FileInputStream fileInputStream = new FileInputStream(filePath);
        MockMultipartFile mockPic = new MockMultipartFile("pic", originalFileNm, "png", fileInputStream);

        String paramJson = objectMapper.writeValueAsString(p);
        MockMultipartFile notice = new MockMultipartFile("param", "param", "application/json", paramJson.getBytes(StandardCharsets.UTF_8));

        mvc.perform(multipart("/api/admin")
                        .file(mockPic)
                        .file(notice)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void putProduct() {
    }

    @Test
    void getProduct() throws Exception{
        //given
        SelListDto dto = new SelListDto();
        dto.setStartIdx(0);
        dto.setRow(15);
        dto.setPage(1);

        PageDto pageDto = new PageDto(100, 1, 15);
        List<ProductVo> list = new ArrayList<>();

        ProductVo vo = ProductVo.builder()
                .productId(1L)
                .nmKor("트라마리 로제 디 프리미티보")
                .price(11300)
                .promotion(0)
                .beginner(0)
                .quantity(6)
                .build();
        list.add(vo);

        ProductList rList = ProductList.builder()
                .page(pageDto)
                .productList(list)
                .build();

        given(service.getProduct(dto)).willReturn(rList); // ProductList rList

        //when
        ResultActions ra = mvc.perform(get("/api/admin/product/list")
                .param("page",String.valueOf(dto.getPage()))
                .param("row",String.valueOf(dto.getRow())));

//        ResultActions ra = mvc.perform(get("/api/admin/product/list"));

        //then
        MvcResult mr = ra.andExpect(status().isOk())
                //.andExpect(jsonPath("$", hasSize(list.size())))
//                .andExpect(jsonPath("$", hasSize(rList.getProductList().size())))
                /*
                     .andExpect(jsonPath("$[*].productId").exists()) //배열의 모든 요소( * )에 productId가 존재하는지 확인
                     .andExpect(jsonPath("$[0].productId").value(1L)) // 배열 0번칸에 productId가 1인지 확인
                     .andExpect(jsonPath("$[0].nmKor").value("트라마리 로제 디 프리미티보"))
                     .andExpect(jsonPath("$[0].price").value(11300))
                     .andExpect(jsonPath("$[0].promotion").value(0))
                     .andExpect(jsonPath("$[0].beginner").value(0))
                     .andExpect(jsonPath("$[0].quantity").value(6))

                 */
                .andDo(print())
                .andReturn();
        String resultStr = mr.getResponse().getContentAsString();
        ObjectMapper om = new ObjectMapper();

        ProductList resultObj = om.readValue(resultStr, ProductList.class);
        log.info("resultObj : {}", resultObj);
//        verify(service).getProduct(dto);
        verify(service).getProduct(any()); //getProduct호출했는지 확인
    }

    @Test
    void putOrderStatus() throws Exception {
        //given
        given(service.updOrderStatus(any(OrderStatusDto.class))).willReturn(1L);

        OrderStatusDto dto = new OrderStatusDto();
        dto.setOrderId(1L);
        dto.setOrderStatus(2);

        String dtoJson = objectMapper.writeValueAsString(dto);

        //when
        ResultActions ra = mvc.perform(put("/api/admin/order")
                .content(dtoJson)
                .contentType(MediaType.APPLICATION_JSON));
        //then
        ra.andExpect(status().isOk())
                .andExpect(content().string("1"))
                .andDo(print());

        verify(service).updOrderStatus(any());
    }

}