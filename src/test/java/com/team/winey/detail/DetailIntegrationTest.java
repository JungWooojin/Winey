package com.team.winey.detail;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.team.winey.detail.model.SelAroma;
import com.team.winey.detail.model.SelSale;
import com.team.winey.detail.model.WineDetailVo;
import com.team.winey.detail.model.WineVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@Slf4j

public class DetailIntegrationTest extends DetailIntegrTest{
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @Rollback(false)
    public void selWineDetail() throws Exception {

        MvcResult mr = mvc.perform(get("/api/detail/111"))
                .andExpect(status().isOk())
                //.andExpect()
                .andExpect(jsonPath("$.level").value(1))
                .andExpect(jsonPath("$.wineDetailVo.categoryNm").value("화이트"))
                .andExpect(jsonPath("$.selPairing[0]").value("fish"))
                .andExpect(jsonPath("$.selPairing[3]").value("cheeze"))
                .andExpect(jsonPath("$.selSale.salePrice").value(27946))
                .andDo(print())
                .andReturn();





    }
}
