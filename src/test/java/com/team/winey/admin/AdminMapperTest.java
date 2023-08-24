//package com.team.winey.admin;
//
//import com.team.winey.admin.model.*;
//import org.junit.jupiter.api.Test;
//import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//@MybatisTest
//@ActiveProfiles("test")
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//class AdminMapperTest {
//
//    @Autowired
//    private AdminMapper mapper;
//
//    @Test
//    void insProduct() throws Exception {
//        ProductInsDto dto = new ProductInsDto();
//        dto.setCategoryId(1);
//        dto.setFeatureId(1);
//        dto.setCountryId(1);
////        dto.setAromaId(1);
//        dto.setNmKor("한글이름");
//        dto.setNmEng("EngName");
//        dto.setPrice(10000);
//        dto.setPic("pic.jpg");
//        dto.setPromotion(1);
//        dto.setBeginner(1);
//        dto.setAlcohol(10);
//        dto.setQuantity(100);
//
//        int r1 = mapper.insProduct(dto);
//        assertEquals(1, r1);
//    }
//
//    @Test
//    void insFeature() {
//        ProductInsDto dto = new ProductInsDto();
//        dto.setSweety(1);
//        dto.setAcidity(1);
//        dto.setBody(1);
//
//        int r1 = mapper.insFeature(dto);
//        assertEquals(1, r1);
//    }
//
//    @Test
//    void insAroma() {
//        ProductAromaParam p = new ProductAromaParam();
//        p.setFlower(1);
//        p.setPlant(1);
//        p.setFruit(0);
//        p.setSpicy(0);
//        p.setEarth(0);
//        p.setOak(1);
//        p.setNuts(0);
//        ProductAromaDto dto = new ProductAromaDto(p);
//
//        int r1 = mapper.insAroma(dto);
//        assertEquals(1, r1);
//    }
//
//    @Test
//    void insSale() {
//        ProductInsDto dto = new ProductInsDto();
//        dto.setProductId(1);
//        dto.setSale(10);
//        dto.setSalePrice(10000);
//        dto.setStartSale("2023-08-08 00:00");
//        dto.setEndSale("2023-08-10 00:00");
//
//        int r1 = mapper.insSale(dto);
//        assertEquals(1, r1);
//    }
//
//    @Test
//    void insWinePairing() {
//        ProductInsDto dto = new ProductInsDto();
//        dto.setProductId(1);
//        dto.setSmallCategoryId(1);
//
//        int r1 = mapper.insWinePairing(dto);
//        assertEquals(1, r1);
//    }
//
//    @Test
//    void selProductFk() {
//        int productId = 1;
//        ProductUpdDto dto = new ProductUpdDto();
//
//        ProductUpdDto r1 = mapper.selProductFk(productId);
//
//        assertEquals(4, r1.getCategoryId());
//        assertEquals(470,r1.getFeatureId());
//        assertEquals(2,r1.getCountryId());
//        assertEquals(470,r1.getAromaId());
//    }
//
//    @Test
//    void updFeature() {
//        ProductUpdDto dto = new ProductUpdDto();
//        dto.setSweety(1);
//        dto.setAcidity(2);
//        dto.setBody(3);
//        dto.setFeatureId(1);
//
//        int r1 = mapper.updFeature(dto);
//        assertEquals(1, r1);
//    }
//
//    @Test
//    void updAroma() {
//        ProductAromaParam p = new ProductAromaParam();
//        p.setFlower(1);
//        p.setPlant(1);
//        p.setFruit(0);
//        p.setSpicy(0);
//        p.setEarth(0);
//        p.setOak(1);
//        p.setNuts(0);
//
//        ProductAromaDto dto = new ProductAromaDto(p);
//        dto.setAromaId(1);
//
//        int r1 = mapper.updAroma(dto);
//        assertEquals(1, r1);
//    }
//
//    @Test
//    void updSale() {
//        ProductUpdDto dto =  new ProductUpdDto();
//        dto.setProductId(1);
//
//        int r1 = mapper.updSale(dto);
//        assertEquals(1, r1);
//    }
//
//    @Test
//    void delWinePairing() {
//        ProductUpdDto dto = new ProductUpdDto();
//        dto.setProductId(1);
//
//        int r1 = mapper.delWinePairing(dto);
//        assertEquals(4, r1);
//    }
//
//    @Test
//    void updProduct() {
//        ProductUpdDto dto = new ProductUpdDto();
//        dto.setCategoryId(1);
//        dto.setFeatureId(1);
//        dto.setCountryId(1);
//        dto.setAromaId(1);
//        dto.setNmKor("한글이름");
//        dto.setNmEng("EngName");
//        dto.setPrice(10000);
//        dto.setPic("pic.jpg");
//        dto.setPromotion(1);
//        dto.setBeginner(1);
//        dto.setAlcohol(10);
//        dto.setQuantity(100);
//        dto.setProductId(1);
//
//        int r1 = mapper.updProduct(dto);
//        assertEquals(1, r1);
//    }
//
//    @Test
//    void selProduct() {
//        SelListDto dto = new SelListDto();
//        dto.setStartIdx(0);
//        dto.setRow(10);
//
//        List<ProductVo> r1 = mapper.selProduct(dto);
//
//        assertEquals(1, r1.get(0).getProductId());
//        assertEquals("트라마리 로제 디 프리미티보", r1.get(0).getNmKor());
//        assertEquals(11300, r1.get(0).getPrice());
//        assertEquals(0,r1.get(0).getPromotion());
//        assertEquals(0,r1.get(0).getBeginner());
//        assertEquals(6, r1.get(0).getQuantity());
//    }
//
//    @Test
//    void selProductSale() {
//        SelListDto dto = new SelListDto();
//        dto.setStartIdx(0);
//        dto.setRow(10);
//
//        List<ProductSaleVo> r1 = mapper.selProductSale(dto);
//
//        assertEquals(1,r1.get(0).getProductId());
//        assertEquals("트라마리 로제 디 프리미티보",r1.get(0).getNmKor());
//        assertEquals(11300,r1.get(0).getPrice());
//        assertEquals(11,r1.get(0).getSale());
//        assertEquals(98104,r1.get(0).getSalePrice());
//        assertEquals(0,r1.get(0).getPromotion());
//        assertEquals(0,r1.get(0).getBeginner());
//        assertEquals(6,r1.get(0).getQuantity());
//        assertEquals(0,r1.get(0).getSaleYn());
//    }
//
//    @Test
//    void selUserList() {
//        SelListDto dto = new SelListDto();
//        dto.setStartIdx(0);
//        dto.setRow(10);
//
//        List<UserVo> r1 = mapper.selUserList(dto);
//
//        assertEquals(1,r1.get(0).getUserId());
//        assertEquals("1@naver.com",r1.get(0).getEmail());
//        assertEquals("이름1",r1.get(0).getNm());
//        assertEquals(10,r1.get(0).getRegionNmId());
//    }
//
//    @Test
//    void selUserOrder() {
//        UserOrderDetailDto dto = new UserOrderDetailDto();
//        dto.setUserId(1L);
//        dto.setStartIdx(0);
//        dto.setRow(15);
//
//        List<UserOrderDetailVo> r1 = mapper.selUserOrder(dto);
//
//        assertEquals(1,r1.get(0).getOrderId());
//        assertEquals("23-08-15", r1.get(0).getOrderDate());
//        assertEquals("소비뇽 블랑",r1.get(0).getNmKor());
//        assertEquals(70097,r1.get(0).getPrice());
//        assertEquals("둔산점",r1.get(0).getStoreNm());
//        assertEquals(5,r1.get(0).getOrderStatus());
//        assertEquals(2,r1.get(0).getCount());
//
//    }
//
//    @Test
//    void selOrder() {
//        SelListDto dto = new SelListDto();
//        dto.setStartIdx(0);
//        dto.setRow(10);
//
//        List<OrderListVo> r1 = mapper.selOrder(dto);
//        assertEquals(1,r1.get(0).getOrderId());
//        assertEquals("23-08-15",r1.get(0).getOrderDate());
//        assertEquals("1@naver.com",r1.get(0).getEmail());
//        assertEquals("소비뇽 블랑",r1.get(0).getNmKor());
//        assertEquals(4,r1.get(0).getQuantity());
//        assertEquals(70097,r1.get(0).getTotalPrice());
//        assertEquals(0,r1.get(0).getPayment());
//        assertEquals("둔산점",r1.get(0).getPickUpStore());
//        assertEquals(2,r1.get(0).getCount());
//    }
//
//    @Test
//    void selOrderDetail() {
//        int orderId = 1;
//        List<OrderDetailVo> r1 = mapper.selOrderDetail(orderId);
//
//        assertEquals(1,r1.get(0).getOrderId());
//        assertEquals("23-08-15",r1.get(0).getOrderDate());
//        assertEquals("소비뇽 블랑",r1.get(0).getNmKor());
//        assertEquals(235894,r1.get(0).getSalePrice());
//        assertEquals(2,r1.get(0).getQuantity());
//        assertEquals(70097,r1.get(0).getTotalPrice());
//        assertEquals(0,r1.get(0).getPayment());
//        assertEquals("둔산점",r1.get(0).getStoreNm());
//        assertEquals("23-08-20",r1.get(0).getPickUpDate());
//        assertEquals("00:00",r1.get(0).getPickUpTime());
//        assertEquals(5,r1.get(0).getOrderStatus());
//
//
//    }
//
//    @Test
//    void selOrderRefund() {
//        SelListDto dto = new SelListDto();
//        dto.setStartIdx(0);
//        dto.setRow(10);
//
//        List<OrderRefundVo> r1 = mapper.selOrderRefund(dto);
//
//        assertEquals(1,r1.get(0).getRefundId());
//        assertEquals(1,r1.get(0).getOrderId());
//        assertEquals("KHIB",r1.get(0).getRefundReason());
//        assertEquals("2023-08-16 00:00:00",r1.get(0).getRefundDate());
//
//
//    }
//
//    @Test
//    void insStore() {
//        StoreInsDto dto = new StoreInsDto();
//        dto.setRegionNmId(1L);
//        dto.setNm("매장이름");
//        dto.setTel("02-123-1234");
//
//        int r1 = mapper.insStore(dto);
//        assertEquals(1, r1);
//    }
//
//    @Test
//    void selStore() {
//        SelListDto dto = new SelListDto();
//        dto.setRow(15);
//        dto.setPage(1);
//        dto.setStartIdx(0);
//
//        List<StoreVo> list = mapper.selStore(dto);
//        assertEquals("목동점",list.get(0).getNm());
//        assertEquals("02-6923-1234",list.get(0).getTel());
//        assertEquals(1,list.get(0).getRegionNmId());
//    }
//
//    @Test
//    void updStore() {
//        StoreInsDto dto = new StoreInsDto();
//        dto.setRegionNmId(1L);
//        dto.setNm("매장이름");
//        dto.setTel("02-123-1234");
//        dto.setStoreId(1L);
//
//        int r1 = mapper.updStore(dto);
//        assertEquals(1, r1);
//    }
//    //안됨
//    @Test
//    void delStore() throws Exception{
//        Long StoreId = 2L;
//
//        Long r1 = mapper.delStore(StoreId);
//        assertEquals(1L, r1);
//    }
//
//    @Test
//    void updOrderStatus() {
//        OrderStatusDto dto = new OrderStatusDto();
//        dto.setOrderStatus(1);
//        dto.setOrderId(1L);
//
//        int r1 = mapper.updOrderStatus(dto);
//        assertEquals(1, r1);
//    }
//    // startSale날짜 db에 있는걸 적기
//    @Test
//    void updSaleYnOn() {
//        ProductUpdDto dto = new ProductUpdDto();
//        dto.setStartSale("2023-08-14 00:00");
//
//        int r1 = mapper.updSaleYnOn(dto);
//        assertEquals(232, r1);
//    }
//
//    @Test
//    void updSaleYnOff() {
//        ProductUpdDto dto = new ProductUpdDto();
//        dto.setEndSale("2023-08-16 00:00");
//
//        int r1 = mapper.updSaleYnOff(dto);
//        assertNotEquals(1,r1);
//    }
//
//    @Test
//    void updSaleYn() {
//        ProductSaleYnDto dto = new ProductSaleYnDto();
//        dto.setSaleYn(1);
//        dto.setProductId(1);
//
//        int r1 = mapper.updSaleYn(dto);
//        assertEquals(1, r1);
//    }
//}