package com.team.winey.main.six;

import com.team.winey.main.model.WineFoodVo;
import com.team.winey.main.model.WineSelByCountryDto;
import com.team.winey.main.model.WineSelByFoodDto;
import com.team.winey.main.model.WineTotalVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class MainSixService {

    private final MainSixMapper MAPPER;

    //6개씩 출력
    public List<WineTotalVo> selWineByPrice2limit6() {
        List<WineTotalVo> wine = MAPPER.selWineByPrice2limit6();
        for (WineTotalVo vo : wine) {
            if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;
    }

    public List<WineTotalVo> selWineByPrice25limit6() {
        List<WineTotalVo> wine = MAPPER.selWineByPrice25limit6();
        for (WineTotalVo vo : wine) {
            if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;
    }

    public List<WineTotalVo> selWineByPrice510limit6() {
        List<WineTotalVo> wine = MAPPER.selWineByPrice510limit6();
        for (WineTotalVo vo : wine) {
            if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;
    }

    public List<WineTotalVo> selWineByPrice10limit6() {
        List<WineTotalVo> wine = MAPPER.selWineByPrice10limit6();
        for (WineTotalVo vo : wine) {
            if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;
    }

    public List<WineTotalVo> selWineByCountrylimit6(WineSelByCountryDto dto) {
        List<WineTotalVo> wine = MAPPER.selWineByCountrylimit6(dto);
        for (WineTotalVo vo : wine) {
            if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;
    }

    public List<WineFoodVo> selWineByFoodlimit6(WineSelByFoodDto dto) {
        List<WineFoodVo> wine = MAPPER.selWineByFoodlimit6(dto);
        for (WineFoodVo vo : wine) {
            if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;
    }

//    public List<WineTotalVo> selWineByday() {
//        return MAPPER.selWineByday();
//    }

   /* @Scheduled(cron = "0 0 0 * * *") // 매일 자정마다 뿌려
    public void selWineByday() {
        List<WineVo> list = MAPPER.selWineByday(); // beginner=1 와인 정보 가져오기

        int totalWines = list.size(); // 가져온 와인 정보의 총 개수
        int wineToDisplay = 6; // 하루에 뿌릴 와인 개수

        if (totalWines <= wineToDisplay) {
            log.info("하루에 표기할 와인: {}", list);
        } else {
            List<WineVo> selectedWine = new ArrayList<>();

            // 랜덤한 인덱스로 랜덤값 선택
            Set<Integer> selectedIndexes = new HashSet<>();
            Random random = new Random();

            while (selectedIndexes.size() < wineToDisplay) {
                int randomIndex = random.nextInt(totalWines);
                selectedIndexes.add(randomIndex);
            }

            for (int index : selectedIndexes) {
                selectedWine.add(list.get(index));
            }

            log.info("Randomly selected wines: {}", selectedWine);
        }
    }*/
}
