package com.team.winey.main.six;

import com.team.winey.config.security.AuthenticationFacade;
import com.team.winey.main.MainMapper;
import com.team.winey.main.model.*;
import com.team.winey.recommend.RecommendMapper;
import com.team.winey.recommend.model.LoginUserDto;
import com.team.winey.recommend.model.SelRecommendDto;
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
    private final MainMapper mainMapper;
    private final AuthenticationFacade facade;

    private final RecommendMapper recommendMapper;

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
    public List<WineTotalVo> getWineByPrice2limit6() {
        return SERVICE.selWineByPrice2limit6();
    }

    @GetMapping("/price25")
    @Operation(summary = "2-5만원 와인리스트 6개")
    public List<WineTotalVo> getWineByPrice25limit6() {
        return SERVICE.selWineByPrice25limit6();
    }

    @GetMapping("/price510")
    @Operation(summary = "5-10만원 와인리스트 6개")
    public List<WineTotalVo> getWineByPrice510limit6() {
        return SERVICE.selWineByPrice510limit6();
    }

    @GetMapping("/price10")
    @Operation(summary = "10만원 이상 와인리스트 6개")
    public List<WineTotalVo> getWineByPrice10limit6() {
        return SERVICE.selWineByPrice10limit6();
    }

    @GetMapping("/country")
    @Operation(summary = "국가별 와인리스트 6개")
    public List<WineTotalVo> getWineByCountrylimit6(@RequestParam Long countryId) {
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

    @GetMapping("/random-wines")
    @Operation(summary = "입문용 와인리스트 6개")
    @Scheduled(cron = "0 0 0 * * *") // 매일 자정 마다 실행
    public List<WineRecommendVo> getRandomWines() {

        //로그인한 userId 불러오기
        Long userId = facade.getLoginUserPk().longValue();

        LoginUserDto dto = new LoginUserDto();
        dto.setUserId(userId);

        //불러온 userId값 넣어주기
        SelRecommendDto selRecommendDto = new SelRecommendDto();
        selRecommendDto.setUserId(userId);
        List<Integer> recommandWines = recommendMapper.selUserinfo(selRecommendDto);
        List<Long> getProductID = new ArrayList<>();

        List<WineRecommendVo> selectedWines = new ArrayList<>();
        List<Integer> totalWines = recommandWines;

        //userId 당 해당하는 productId 담기
        for (Integer wineId : recommandWines) {
            getProductID.add(wineId.longValue());
        }

        //랜덤 6개 출력하기
        List<WineRecommendVo> allWines = MAPPER.selWineByday(userId);
        int winesToDisplay = 6;

        if (getProductID.size() <= winesToDisplay) {
            selectedWines.addAll(allWines);
        } else {
            Set<Integer> selectedIndexes = new HashSet<>();
            Random random = new Random();

            while (selectedIndexes.size() < winesToDisplay) {
                int randomIndex = random.nextInt(getProductID.size());
                selectedIndexes.add(randomIndex);
            }

            for (int index : selectedIndexes) {
                selectedWines.add(allWines.get(index));
            }
        }

        return selectedWines;
    }
}
