package com.team.winey.main.six;

import com.team.winey.main.model.WineFoodVo;
import com.team.winey.main.model.WineSelByCountryDto;
import com.team.winey.main.model.WineSelByFoodDto;
import com.team.winey.main.model.WineVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainSixMapper {
    //6개씩 출력
    List<WineVo> selWineByPrice2limit6();
    List<WineVo> selWineByPrice25limit6();
    List<WineVo> selWineByPrice510limit6();
    List<WineVo> selWineByPrice10limit6();
    List<WineVo> selWineByCountrylimit6(WineSelByCountryDto dto);
    List<WineFoodVo> selWineByFoodlimit6(WineSelByFoodDto dto);

}
