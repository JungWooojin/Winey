package com.team.winey.main;

import com.team.winey.detail.model.WineVo;
import com.team.winey.main.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainMapper {
    List<WineTotalVo> selWine();

    //    List<WineVo> selWineByPrice(WineSelByPriceDto dto);
    WineVo selWineById(WineSelDetailDto productId);
    List<WineTotalVo> selWineByPrice2();
    List<WineTotalVo> selWineByPrice25();
    List<WineTotalVo> selWineByPrice510();
    List<WineTotalVo> selWineByPrice10();
    List<WineTotalVo> selWineByCountry(WineSelByCountryDto dto);
    List<WineFoodVo> selWineByFood(WineSelByFoodDto dto);


}
