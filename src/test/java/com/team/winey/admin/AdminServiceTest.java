package com.team.winey.admin;

import com.team.winey.admin.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@Import({AdminService.class })
@TestPropertySource(properties = {
        "file.dir = /home/download"
}) //이걸 적으면 TodoServiceImpl의 생성자 매개변수 @Value에 들어가게됨(?)
class AdminServiceTest {

    @MockBean
    private AdminMapper mapper;

    @Autowired
    private AdminService service;

    @Test
    void postProduct() throws Exception{
        //given
        String originalFileNm = "14cf6643-a057-4933-a6df-43944faf7668";
        String contentType = "png";
        String filePath = "D:/home/download/winey/product/1477/" + originalFileNm + "." + contentType;
        FileInputStream fileInputStream = new FileInputStream(filePath);
        MultipartFile pic = new MockMultipartFile("pic", originalFileNm, "png", fileInputStream);

        ProductInsDto d = new ProductInsDto();

        //insFeature용
        d.setSweety(1);
        d.setAcidity(2);
        d.setBody(3);

        int r2 = mapper.insFeature(d);
        assertEquals(0, r2);

        //when
        when(mapper.insFeature(any())).thenReturn(1);

        //given
        //insAroma용
        ProductAromaParam aroma = new ProductAromaParam();
        aroma.setEarth(1);
        aroma.setOak(1);
        aroma.setNuts(0);
        aroma.setPlant(0);
        aroma.setFruit(0);
        aroma.setFlower(1);
        aroma.setSpicy(0);

        ProductAromaDto aromaDto = new ProductAromaDto(aroma);
        int r3 = mapper.insAroma(aromaDto);
        //when
        when(mapper.insAroma(any())).thenReturn(1);

        //given
        //insProduct
        d.setProductId(1);
        d.setCategoryId(1);
        d.setFeatureId(1);
        d.setCountryId(1);
        d.setAromaId(1);
        d.setNmKor("한글이름");
        d.setNmEng("EngName");
        d.setPrice(10000);

        d.setPic("14cf6643-a057-4933-a6df-43944faf7668.png");

        d.setPromotion(1);
        d.setBeginner(1);
        d.setAlcohol(10);
        d.setQuantity(100);

        int r4 = mapper.insProduct(d);
        //when
        when(mapper.insProduct(any())).thenReturn(1);
        assertEquals(0,r4);


        d.setAromaId(1); //

        //given
        //insSale
        d.setSale(10);
        d.setSalePrice(9000);
        d.setStartSale("2023-08-08 00:00");
        d.setEndSale("2023-08-09 00:00");

        int r5 = mapper.insSale(d);
        //when
        when(mapper.insSale(any())).thenReturn(1);
        assertEquals(0,r5);

        List<Integer> smallCategoryId = new ArrayList<>();
        smallCategoryId.add(1);
        smallCategoryId.add(2);
        d.setSmallCategoryId(1);//

        //then
        verify(mapper).insFeature(any());
        verify(mapper).insAroma(any());
        verify(mapper).insProduct(any());
        verify(mapper).insSale(any());
    }

    @Test
    void putProduct() {
    }

    @Test
    void updSaleDateTime() {
    }

    @Test
    void deleteProductPic() {
    }

    @Test
    void getProduct() {
        //given
        SelListDto dto = new SelListDto();
        dto.setStartIdx(0);
        dto.setRow(15);
        List<ProductVo> mockList = new ArrayList<>();

        ProductVo vo = ProductVo.builder()
                .productId(1L)
                .nmKor("트라마리 로제 디 프리미티보")
                .price(11300)
                .beginner(0)
                .promotion(0)
                .quantity(6)
                .build();
        mockList.add(vo);


        //when
        Mockito.when(this.mapper.selProduct(dto)).thenReturn(mockList);
        //then
        List<ProductVo> actualList = mapper.selProduct(dto);
        Assertions.assertEquals(mockList, actualList);
        (Mockito.verify(this.mapper)).selProduct(dto);


    }

    @Test
    void getProductSale() {
        //given
        SelListDto dto = new SelListDto();
        dto.setStartIdx(0);
        dto.setRow(15);

        List<ProductSaleVo> mockList = new ArrayList<>();
        ProductSaleVo vo = ProductSaleVo.builder()
                .productId(1L)
                .nmKor("트라마리 로제 디 프리미티보")
                .price(11300)
                .sale(11)
                .promotion(0)
                .beginner(0)
                .quantity(6)
                .saleYn(0)
                .build();

        mockList.add(vo);
        //when
        Mockito.when(this.mapper.selProductSale(dto)).thenReturn(mockList);
        //then
        List<ProductSaleVo> actualList = mapper.selProductSale(dto);
        Assertions.assertEquals(mockList, actualList);
        (Mockito.verify(this.mapper)).selProductSale(dto);
    }

    @Test
    void getUserList() {
        //given
        SelListDto dto = new SelListDto();
        dto.setStartIdx(0);
        dto.setRow(15);

        List<UserVo> mockList = new ArrayList<>();
        UserVo vo = UserVo.builder()
                .userId(1L)
                .email("do123@naver.com")
                .nm("노정민")
                .regionNmId(3)
                .build();

        mockList.add(vo);
        //when
        Mockito.when(this.mapper.selUserList(dto)).thenReturn(mockList);
        //then
        List<UserVo> actualList = mapper.selUserList(dto);
        Assertions.assertEquals(mockList, actualList);
        (Mockito.verify(this.mapper)).selUserList(dto);
    }
    //@builder 문제
    @Test
    void getUserOrder() {
    }

    @Test
    void getOrder() {
        //given
        SelListDto dto = new SelListDto();
        dto.setStartIdx(0);
        dto.setRow(15);

        List<OrderListVo> mockList = new ArrayList<>();
        OrderListVo vo = new OrderListVo();
        vo.setOrderId(1L);
        vo.setOrderDate("23-08-15");
        vo.setEmail("do123@naver.com");
        vo.setNmKor("트라마리 로제 디 프리미티보 외 2");
        vo.setQuantity(9);
        vo.setTotalPrice(70097);
        vo.setPayment(0);
        vo.setPickUpStore("둔산점");
        vo.setCount(3);

        mockList.add(vo);
        //when
        Mockito.when(this.mapper.selOrder(dto)).thenReturn(mockList);
        //then
        List<OrderListVo> actualList = mapper.selOrder(dto);
        Assertions.assertEquals(mockList, actualList);
        (Mockito.verify(this.mapper)).selOrder(dto);
    }

    @Test
    void getOrderDetail() {
        //given
        int orderId = 1;
        List<OrderDetailVo> mockList = new ArrayList<>();
        OrderDetailVo vo = OrderDetailVo.builder()
                .orderId(1L)
                .orderDate("23-08-15")
                .email("do123@naver.com")
                .nmKor("트라마리 로제 디 프리미티보")
                .salePrice(41470)
                .quantity(5)
                .totalPrice(70097)
                .payment(0)
                .storeNm("둔산점")
                .pickUpDate("23-08-20")
                .pickUpTime("00:00")
                .orderStatus(0)
                .build();

        mockList.add(vo);
        //when
        Mockito.when(this.mapper.selOrderDetail(orderId)).thenReturn(mockList);

        //then
        List<OrderDetailVo> actualList = mapper.selOrderDetail(orderId);
        Assertions.assertEquals(mockList, actualList);
        (Mockito.verify(this.mapper)).selOrderDetail(orderId);
    }

    @Test
    void getOrderRefund() {
        //given
        SelListDto dto = new SelListDto();
        dto.setStartIdx(0);
        dto.setRow(15);

        List<OrderRefundVo> mockList = new ArrayList<>();
        OrderRefundVo vo = OrderRefundVo.builder()
                .refundId(1L)
                .orderId(1L)
                .refundReason("호나불이유")
                .refundYn(1)
                .refundDate("2023-08-10 11:52:38")
                .build();

        mockList.add(vo);
        //when
        Mockito.when(this.mapper.selOrderRefund(dto)).thenReturn(mockList);

        //then
        List<OrderRefundVo> actualList = mapper.selOrderRefund(dto);
        Assertions.assertEquals(mockList, actualList);
        (Mockito.verify(this.mapper)).selOrderRefund(dto);
    }

    // ????????
    @Test
    void insStore() {
        StoreInsDto dto = new StoreInsDto();
        dto.setRegionNmId(1L);
        dto.setNm("검단점");
        dto.setTel("02-1234-1234");

        String pattern = "(\\d{2,3})-(\\d{3,4})-(\\d{4})";



        int r1 = mapper.insStore(dto);

        when(mapper.insStore(any())).thenReturn(1);
        assertEquals(0,r1);

    }

    @Test
    void getStore() {
        //given
        SelListDto dto = new SelListDto();
        dto.setStartIdx(0);
        dto.setRow(15);

        List<StoreVo> mockList = new ArrayList<>();
        StoreVo vo = StoreVo.builder()
                .storeId(1L)
                .regionNmId(1L)
                .nm("목동점")
                .tel("02-6923-1234")
                .build();

        mockList.add(vo);

        //when
        Mockito.when(this.mapper.selStore(dto)).thenReturn(mockList);

        //then
        List<StoreVo> actualList = mapper.selStore(dto);
        Assertions.assertEquals(mockList, actualList);
        (Mockito.verify(this.mapper)).selStore(dto);

        verify(mapper).selStore(dto);
    }

    @Test
    void updStore() {
        //given
        StoreInsDto dto = new StoreInsDto();
        dto.setStoreId(1L);
        dto.setTel("02-1234-1234");
        dto.setNm("목동점");
        dto.setRegionNmId(2L);

        StoreInsParam param = new StoreInsParam();
        param.setRegionNmId(2L);
        param.setNm("목동점");
        param.setTel("02-1234-1234");

        Long storeId = 1L;

        //when
        when(mapper.updStore(dto)).thenReturn(1);
        Long r1 = service.updStore(param, storeId);

        //then
        assertEquals(1, r1);

        verify(mapper).updStore(any());
    }

    @Test
    void deleteStore() {
    }

    @Test
    void updOrderStatus() {

    }

    @Test
    void putProductSaleYn() {
    }
}