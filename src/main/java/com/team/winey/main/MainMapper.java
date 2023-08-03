package com.team.winey.main;

import com.team.winey.main.model.WineFoodVo;
import com.team.winey.main.model.WineSelByCountryDto;
import com.team.winey.main.model.WineSelByFoodDto;
import com.team.winey.main.model.WineVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainMapper {
    List<WineVo> selWine();
//    List<WineVo> selWineByPrice(WineSelByPriceDto dto);
    List<WineVo> selWineByPrice2();
    List<WineVo> selWineByPrice25();
    List<WineVo> selWineByPrice510();
    List<WineVo> selWineByPrice10();
    List<WineVo> selWineByCountry(WineSelByCountryDto dto);
    List<WineFoodVo> selWineByFood(WineSelByFoodDto dto);


}
