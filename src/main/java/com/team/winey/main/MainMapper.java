package com.team.winey.main;

import com.team.winey.main.model.WineFoodVo;
import com.team.winey.main.model.WineSelByCountryDto;
import com.team.winey.main.model.WineSelByFoodDto;
import com.team.winey.main.model.WineTotalVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainMapper {
    List<WineTotalVo> selWine();
//    List<WineVo> selWineByPrice(WineSelByPriceDto dto);
    List<WineTotalVo> selWineByPrice2();
    List<WineTotalVo> selWineByPrice25();
    List<WineTotalVo> selWineByPrice510();
    List<WineTotalVo> selWineByPrice10();
    List<WineTotalVo> selWineByCountry(WineSelByCountryDto dto);
    List<WineFoodVo> selWineByFood(WineSelByFoodDto dto);


}
