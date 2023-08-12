package com.team.winey.main.six;

import com.team.winey.main.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainSixMapper {
    //6개씩 출력
    List<WineTotalVo> selWineByPrice2limit6();
    List<WineTotalVo> selWineByPrice25limit6();
    List<WineTotalVo> selWineByPrice510limit6();
    List<WineTotalVo> selWineByPrice10limit6();
    List<WineTotalVo> selWineByCountrylimit6(WineSelByCountryDto dto);
    List<WineFoodVo> selWineByFoodlimit6(WineSelByFoodDto dto);

    List<WineRecommandVo> selWineByday(Long val);

}
