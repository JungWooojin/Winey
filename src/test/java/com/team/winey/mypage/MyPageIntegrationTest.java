package com.team.winey.mypage;

import com.team.winey.detail.DetailIntegrationTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.annotation.Rollback;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MvcResult;
import static org.mockito.Mockito.verify;
import lombok.extern.slf4j.Slf4j;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@Slf4j
public class MyPageIntegrationTest extends DetailIntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @Rollback(false)
    public void putUser()throws Exception{
//        MvcResult mr = mvc.perform(patch("/api/upduser"));
    }


}
