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
        return MAPPER.selWineByPrice2limit6();
    }

    public List<WineTotalVo> selWineByPrice25limit6() {
        return MAPPER.selWineByPrice25limit6();
    }

    public List<WineTotalVo> selWineByPrice510limit6() {
        return MAPPER.selWineByPrice510limit6();
    }

    public List<WineTotalVo> selWineByPrice10limit6() {
        return MAPPER.selWineByPrice10limit6();
    }

    public List<WineTotalVo> selWineByCountrylimit6(WineSelByCountryDto dto) {
        return MAPPER.selWineByCountrylimit6(dto);
    }

    public List<WineFoodVo> selWineByFoodlimit6(WineSelByFoodDto dto) {
        return MAPPER.selWineByFoodlimit6(dto);
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
