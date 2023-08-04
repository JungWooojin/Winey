package com.team.winey.main;

import com.team.winey.main.model.WineFoodVo;
import com.team.winey.main.model.WineSelByCountryDto;
import com.team.winey.main.model.WineSelByFoodDto;
import com.team.winey.main.model.WineTotalVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/price")
    @Operation(summary = "전체 와인리스트")
    public List<WineTotalVo> getWineByPrice() {
        return SERVICE.selWine();
    }

    @GetMapping("/price2")
    @Operation(summary = "2만원 미만 와인리스트")
    public List<WineTotalVo> getWineByPrice2() {
        return SERVICE.selWineByPrice2();
    }

    @GetMapping("/price25")
    @Operation(summary = "2-5만원 와인리스트")
    public List<WineTotalVo> getWineByPrice25() {
        return SERVICE.selWineByPrice25();
    }

    @GetMapping("/price510")
    @Operation(summary = "5-10만원 와인리스트")
    public List<WineTotalVo> getWineByPrice510() {
        return SERVICE.selWineByPrice510();
    }

    @GetMapping("/price10")
    @Operation(summary = "10만원 이상 와인리스트")
    public List<WineTotalVo> getWineByPrice10() {
        return SERVICE.selWineByPrice10();
    }

    @GetMapping("/country")
    @Operation(summary = "국가별 와인리스트")
    public List<WineTotalVo> selWineByCountry(@RequestParam Long countryId) {
        WineSelByCountryDto dto = new WineSelByCountryDto();
        dto.setCountryId(countryId);
        return SERVICE.selWineByCountry(dto);
    }

    @GetMapping("/food")
    @Operation(summary = "음식별 와인리스트")
    public List<WineFoodVo> selWineByFood(@RequestParam Long bigCategoryId) {
        WineSelByFoodDto dto = new WineSelByFoodDto();
        dto.setBigCategoryId(bigCategoryId);
        return SERVICE.selWineByFood(dto);
    }
}