package com.team.winey.payment;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class PaymentMapperTest {

    @Test
    void insPayment() {

    }

    @Test
    void insEachPayment() {
    }

    @Test
    void updBuy() {
    }

    @Test
    void updPayment() {
    }

    @Test
    void insReview() {
    }

    @Test
    void insOrderDetail() {
    }

    @Test
    void selRegion() {
    }
}