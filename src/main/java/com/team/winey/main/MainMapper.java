package com.team.winey.main;

import com.team.winey.main.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainMapper {

    WineFeatureVo beginners(WineFeatureDto dto);
    List<WineTotalVo> selWine(WineSelDto dto);
    List<WineTotalVo> selWineByNew(WineSelDto dto);
    List<WineTotalVo> selWineByExpencive(WineSelDto dto);
    List<WineTotalVo> selWineByCheap(WineSelDto dto);

    //    List<WineVo> selWineByPrice(WineSelByPriceDto dto);
    WineTotalVo selWineById(WineSelDetailDto dto);

    List<WineTotalVo> selWineByPrice2(WineSelDto dto);
    List<WineTotalVo> selWineByPrice2New(WineSelDto dto);
    List<WineTotalVo> selWineByPrice2Expencive(WineSelDto dto);
    List<WineTotalVo> selWineByPrice2Cheap(WineSelDto dto);

    List<WineTotalVo> selWineByPrice25(WineSelDto dto);
    List<WineTotalVo> selWineByPrice25New(WineSelDto dto);
    List<WineTotalVo> selWineByPrice25Expencive(WineSelDto dto);
    List<WineTotalVo> selWineByPrice25Cheap(WineSelDto dto);

    List<WineTotalVo> selWineByPrice510(WineSelDto dto);
    List<WineTotalVo> selWineByPrice510New(WineSelDto dto);
    List<WineTotalVo> selWineByPrice510Expencive(WineSelDto dto);
    List<WineTotalVo> selWineByPrice510Cheap(WineSelDto dto);

    List<WineTotalVo> selWineByPrice10(WineSelDto dto);
    List<WineTotalVo> selWineByPrice10New(WineSelDto dto);
    List<WineTotalVo> selWineByPrice10Expencive(WineSelDto dto);
    List<WineTotalVo> selWineByPrice10Cheap(WineSelDto dto);

    List<WineTotalVo> selWineByCountry(WineSelByCountryDto dto);
    List<WineTotalVo> selWineByCountryNew(WineSelByCountryDto dto);
    List<WineTotalVo> selWineByCountryExpencive(WineSelByCountryDto dto);
    List<WineTotalVo> selWineByCountryCheap(WineSelByCountryDto dto);

    List<WineTotalVo> selWineByFood(WineSelByFoodDto dto);
    List<WineTotalVo> selWineByFoodNew(WineSelByFoodDto dto);
    List<WineTotalVo> selWineByFoodExpencive(WineSelByFoodDto dto);
    List<WineTotalVo> selWineByFoodCheap(WineSelByFoodDto dto);


}
