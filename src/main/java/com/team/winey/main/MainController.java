package com.team.winey.main;

import com.team.winey.detail.model.WineVo;
import com.team.winey.main.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "와인 리스트")
@RestController
@RequestMapping("/api/main")
@RequiredArgsConstructor
public class MainController {

    @Bean
    public OpenAPI OpenAPI() {
        final Info info = new Info().version("v1.0.0").title("winey").description("FINAL PROJECT");
        return new OpenAPI().info(info);
    }

    private final MainService SERVICE;

    @GetMapping("/wines")
    @Operation(summary = "전체 와인리스트", description = "{<br>" +
            "    \"productId\": 상품 PK값,<br>" +
            "    \"categoryId\": 카테고리 PK값,<br>" +
            "    \"featureId\": 맛 PK값,<br>" +
            "    \"countryId\": 국가 PK값,<br>" +
            "    \"aromaId\": 향 PK값,<br>" +
            "    \"nmKor\": 한글 이름,<br>" +
            "    \"nmEng\": 영어 이름,<br>" +
            "    \"price\": 가격,<br>" +
            "    \"quantity\": 수량,<br>" +
            "    \"pic\": 사진,<br>" +
            "    \"promotion\": 프로모션,<br>" +
            "    \"beginner\": 입문자,<br>" +
            "    \"alcohol\": 알코올 도수<br>" +
            "  }")
    public List<WineTotalVo> getWineByPrice() {
        return SERVICE.selWine();
    }

    @GetMapping("/wines/{productId}")
    @Operation(summary = "와인 디테일")
    public WineVo getWinebyId(@PathVariable Long productId) {
        return SERVICE.selWineById(new WineSelDetailDto(productId));
    }

    @GetMapping("/price2")
    @Operation(summary = "2만원 미만 와인리스트", description = "{<br>" +
            "    \"productId\": 상품 PK값,<br>" +
            "    \"categoryId\": 카테고리 PK값,<br>" +
            "    \"featureId\": 맛 PK값,<br>" +
            "    \"countryId\": 국가 PK값,<br>" +
            "    \"aromaId\": 향 PK값,<br>" +
            "    \"nmKor\": 한글 이름,<br>" +
            "    \"nmEng\": 영어 이름,<br>" +
            "    \"price\": 가격,<br>" +
            "    \"quantity\": 수량,<br>" +
            "    \"pic\": 사진,<br>" +
            "    \"promotion\": 프로모션,<br>" +
            "    \"beginner\": 입문자,<br>" +
            "    \"alcohol\": 알코올 도수<br>" +
            "  }")
    public List<WineTotalVo> getWineByPrice2() {
        return SERVICE.selWineByPrice2();
    }

    @GetMapping("/price25")
    @Operation(summary = "2-5만원 와인리스트", description = "{<br>" +
            "    \"productId\": 상품 PK값,<br>" +
            "    \"categoryId\": 카테고리 PK값,<br>" +
            "    \"featureId\": 맛 PK값,<br>" +
            "    \"countryId\": 국가 PK값,<br>" +
            "    \"aromaId\": 향 PK값,<br>" +
            "    \"nmKor\": 한글 이름,<br>" +
            "    \"nmEng\": 영어 이름,<br>" +
            "    \"price\": 가격,<br>" +
            "    \"quantity\": 수량,<br>" +
            "    \"pic\": 사진,<br>" +
            "    \"promotion\": 프로모션,<br>" +
            "    \"beginner\": 입문자,<br>" +
            "    \"alcohol\": 알코올 도수<br>" +
            "  }")
    public List<WineTotalVo> getWineByPrice25() {
        return SERVICE.selWineByPrice25();
    }

    @GetMapping("/price510")
    @Operation(summary = "5-10만원 와인리스트", description = "{<br>" +
            "    \"productId\": 상품 PK값,<br>" +
            "    \"categoryId\": 카테고리 PK값,<br>" +
            "    \"featureId\": 맛 PK값,<br>" +
            "    \"countryId\": 국가 PK값,<br>" +
            "    \"aromaId\": 향 PK값,<br>" +
            "    \"nmKor\": 한글 이름,<br>" +
            "    \"nmEng\": 영어 이름,<br>" +
            "    \"price\": 가격,<br>" +
            "    \"quantity\": 수량,<br>" +
            "    \"pic\": 사진,<br>" +
            "    \"promotion\": 프로모션,<br>" +
            "    \"beginner\": 입문자,<br>" +
            "    \"alcohol\": 알코올 도수<br>" +
            "  }")
    public List<WineTotalVo> getWineByPrice510() {
        return SERVICE.selWineByPrice510();
    }

    @GetMapping("/price10")
    @Operation(summary = "10만원 이상 와인리스트", description = "{<br>" +
            "    \"productId\": 상품 PK값,<br>" +
            "    \"categoryId\": 카테고리 PK값,<br>" +
            "    \"featureId\": 맛 PK값,<br>" +
            "    \"countryId\": 국가 PK값,<br>" +
            "    \"aromaId\": 향 PK값,<br>" +
            "    \"nmKor\": 한글 이름,<br>" +
            "    \"nmEng\": 영어 이름,<br>" +
            "    \"price\": 가격,<br>" +
            "    \"quantity\": 수량,<br>" +
            "    \"pic\": 사진,<br>" +
            "    \"promotion\": 프로모션,<br>" +
            "    \"beginner\": 입문자,<br>" +
            "    \"alcohol\": 알코올 도수<br>" +
            "  }")
    public List<WineTotalVo> getWineByPrice10() {
        return SERVICE.selWineByPrice10();
    }

    @GetMapping("/country")
    @Operation(summary = "국가별 와인리스트", description = "\"countryId\": 국가 PK값 입력 </br></br>" +
            "1 : 미국<br>" +
            "2 : 스페인<br>" +
            "3 : 프랑스<br>" +
            "4 : 이탈리아<br>" +
            "5 : 포르투갈<br>" +
            "6 : 칠레<br><br>" +
            "{<br>" +
            "    \"productId\": 상품 PK값,<br>" +
            "    \"categoryId\": 카테고리 PK값,<br>" +
            "    \"featureId\": 맛 PK값,<br>" +
            "    \"countryId\": 국가 PK값,<br>" +
            "    \"aromaId\": 향 PK값,<br>" +
            "    \"nmKor\": 한글 이름,<br>" +
            "    \"nmEng\": 영어 이름,<br>" +
            "    \"price\": 가격,<br>" +
            "    \"quantity\": 수량,<br>" +
            "    \"pic\": 사진,<br>" +
            "    \"promotion\": 프로모션,<br>" +
            "    \"beginner\": 입문자,<br>" +
            "    \"alcohol\": 알코올 도수<br>" +
            "  }")
    public List<WineTotalVo> selWineByCountry(@RequestParam Long countryId) {
        WineSelByCountryDto dto = new WineSelByCountryDto();
        dto.setCountryId(countryId);
        return SERVICE.selWineByCountry(dto);
    }

    @GetMapping("/food")
    @Operation(summary = "음식별 와인리스트", description = "\"bigCategoryId\": 음식 카테고리 입력</br></br>" +
            "1 : meet</br>" +
            "2 : seafood</br>" +
            "3 : otherfood</br></br>" +
            "{<br>" +
            "    \"productId\": 상품 PK값,<br>" +
            "    \"categoryId\": 카테고리 PK값,<br>" +
            "    \"featureId\": 맛 PK값,<br>" +
            "    \"countryId\": 국가 PK값,<br>" +
            "    \"aromaId\": 향 PK값,<br>" +
            "    \"nmKor\": 한글 이름,<br>" +
            "    \"nmEng\": 영어 이름,<br>" +
            "    \"price\": 가격,<br>" +
            "    \"quantity\": 수량,<br>" +
            "    \"pic\": 사진,<br>" +
            "    \"promotion\": 프로모션,<br>" +
            "    \"beginner\": 입문자,<br>" +
            "    \"alcohol\": 알코올 도수<br>" +
            "  }")
    public List<WineFoodVo> selWineByFood(@RequestParam Long bigCategoryId) {
        WineSelByFoodDto dto = new WineSelByFoodDto();
        dto.setBigCategoryId(bigCategoryId);
        return SERVICE.selWineByFood(dto);
    }
}