package com.team.winey.payment;

import com.team.winey.config.security.AuthenticationFacade;
import com.team.winey.payment.model.*;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import javax.swing.plaf.synth.Region;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class PaymentMapperTest {

    @MockBean
    private AuthenticationFacade facade;

    @Autowired
    private PaymentMapper mapper;
    @Test
    void insPayment() {
        PaymentInsDto2 dto2 = new PaymentInsDto2();
        dto2.setUserId(1L);
        dto2.setTotalOrderPrice(4519619);
        dto2.setStoreId(2);
        dto2.setPickupTime("2023-08-04");

        int result = mapper.insPayment(dto2);
        assertEquals(1,result);


    }

    @Test
    void insEachPayment() {
        EachPaymentInsDto2 dto2 = new EachPaymentInsDto2();
        dto2.setUserId(1L);
        dto2.setOrderId(4);
        dto2.setStoreId(2);
        dto2.setPayment(1);
        dto2.setSalePrice(1080000);
        dto2.setQuantity(3);
        dto2.setProductId(3);

        int result = mapper.insEachPayment(dto2);
        assertEquals(1,result);
    }

    @Test
    void insReview() {
        ReviewInsDto dto = new ReviewInsDto();
        dto.setUserId(1l);
        dto.setReviewLevel(1);
        dto.setOrderDetailId(1);

        int result = mapper.insReview(dto);
        assertEquals(1,result);
    }

    @Test
    void insOrderDetail() {
        OrderDetailInsDto dto = new OrderDetailInsDto();
        dto.setOrderId(4);
        dto.setProductId(3);
        dto.setQuantity(3);
        dto.setSalePrice(1080000);

        int result = mapper.insOrderDetail(dto);
        assertEquals(1,result);
    }

    @Test
    void selRegion() {
        RegionInsDto dto = new RegionInsDto();
        dto.setUserId(1l);
        List<RegionSelVO> list = mapper.selRegion(dto);
        assertEquals(3,list.size());

    }
}