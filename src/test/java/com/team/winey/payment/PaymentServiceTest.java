package com.team.winey.payment;

import com.team.winey.config.security.AuthenticationFacade;
import com.team.winey.payment.model.PaymentInsDto2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@Import({PaymentService.class})
class PaymentServiceTest {

    @MockBean
    private PaymentMapper mapper;

    @MockBean
    private AuthenticationFacade facade;

    @Autowired
    private PaymentService service;

    @Test
    void insPayment() {
    }

    @Test
    void insEachPayment() {
    }

    @Test
    void updPayment() {
    }

    @Test
    void insReview() {
    }

    @Test
    void selRegion() {
    }
}