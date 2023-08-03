package com.team.winey.main.six;

import com.team.winey.main.model.WineFoodVo;
import com.team.winey.main.model.WineSelByCountryDto;
import com.team.winey.main.model.WineSelByFoodDto;
import com.team.winey.main.model.WineVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Tag(name = "와인 리스트 6개")
@RestController
@RequestMapping("/api/main/6")
@RequiredArgsConstructor
public class MainSixController {


    private final MainSixService SERVICE;
    private final MainSixMapper MAPPER;

    /*@GetMapping("/price")
    @Operation(summary = "가격별 와인리스트")
    public List<WineVo> getWineByPrice(@RequestParam int num) {
        WineSelByPriceDto dto = new WineSelByPriceDto();
        dto.setNumber(num);
        return SERVICE.selWineByPrice(dto);
    }*/

    //6개 출력
    @GetMapping("/price2")
    @Operation(summary = "2만원 미만 와인리스트 6개")
    public List<WineVo> getWineByPrice2limit6() {
        return SERVICE.selWineByPrice2limit6();
    }

    @GetMapping("/price25")
    @Operation(summary = "2-5만원 와인리스트 6개")
    public List<WineVo> getWineByPrice25limit6() {
        return SERVICE.selWineByPrice25limit6();
    }

    @GetMapping("/price510")
    @Operation(summary = "5-10만원 와인리스트 6개")
    public List<WineVo> getWineByPrice510limit6() {
        return SERVICE.selWineByPrice510limit6();
    }

    @GetMapping("/price10")
    @Operation(summary = "10만원 이상 와인리스트 6개")
    public List<WineVo> getWineByPrice10limit6() {
        return SERVICE.selWineByPrice10limit6();
    }

    @GetMapping("/country")
    @Operation(summary = "국가별 와인리스트 6개")
    public List<WineVo> getWineByCountrylimit6(@RequestParam Long countryId) {
        WineSelByCountryDto dto = new WineSelByCountryDto();
        dto.setCountryId(countryId);
        return SERVICE.selWineByCountrylimit6(dto);
    }

    @GetMapping("/food")
    @Operation(summary = "음식별 와인리스트 6개")
    public List<WineFoodVo> getWineByFoodlimit6(@RequestParam Long bigCategoryId) {
        WineSelByFoodDto dto = new WineSelByFoodDto();
        dto.setBigCategoryId(bigCategoryId);
        return SERVICE.selWineByFoodlimit6(dto);
    }

    /*    @GetMapping("/beginner")
    @Operation(summary = "입문용 추천 6개")
    public void getWineByday() {
        SERVICE.selWineByday();
    }*/
    @GetMapping("/random-wines")
    @Operation(summary = "입문용 와인리스트 6개")
    @Scheduled(cron = "0 0 0 * * *") // 매 시간 0분마다 실행
    public List<WineVo> getRandomWines() {
        List<WineVo> allWines = MAPPER.selWineByday();
        List<WineVo> selectedWines = new ArrayList<>();

        int totalWines = allWines.size();
        int winesToDisplay = 6;

        if (totalWines <= winesToDisplay) {
            selectedWines.addAll(allWines);
        } else {
            Set<Integer> selectedIndexes = new HashSet<>();
            Random random = new Random();

            while (selectedIndexes.size() < winesToDisplay) {
                int randomIndex = random.nextInt(totalWines);
                selectedIndexes.add(randomIndex);
            }

            for (int index : selectedIndexes) {
                selectedWines.add(allWines.get(index));
            }
        }

        return selectedWines;
    }
}
