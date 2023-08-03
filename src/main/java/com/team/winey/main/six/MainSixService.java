package com.team.winey.main.six;

import com.team.winey.main.model.WineFoodVo;
import com.team.winey.main.model.WineSelByCountryDto;
import com.team.winey.main.model.WineSelByFoodDto;
import com.team.winey.main.model.WineVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainSixService {

    private final MainSixMapper MAPPER;
    
    //6개씩 출력
    public List<WineVo> selWineByPrice2limit6() {
        return MAPPER.selWineByPrice2limit6();
    }

    public List<WineVo> selWineByPrice25limit6() {
        return MAPPER.selWineByPrice25limit6();
    }

    public List<WineVo> selWineByPrice510limit6() {
        return MAPPER.selWineByPrice510limit6();
    }

    public List<WineVo> selWineByPrice10limit6() {
        return MAPPER.selWineByPrice10limit6();
    }

    public List<WineVo> selWineByCountrylimit6(WineSelByCountryDto dto) {
        return MAPPER.selWineByCountrylimit6(dto);
    }

    public List<WineFoodVo> selWineByFoodlimit6(WineSelByFoodDto dto) {
        return MAPPER.selWineByFoodlimit6(dto);
    }

}
