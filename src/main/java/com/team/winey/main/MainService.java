package com.team.winey.main;

import com.team.winey.detail.model.WineVo;
import com.team.winey.main.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainService {

    private final MainMapper MAPPER;

    public List<WineTotalVo> selWine() {
        return MAPPER.selWine();
    }

    //    public List<WineVo> selWineByPrice(WineSelByPriceDto dto) {
//        return MAPPER.selWineByPrice(dto);
//    }
    public WineVo selWineById(WineSelDetailDto dto) {
        return MAPPER.selWineById(dto);
    }

    public List<WineTotalVo> selWineByPrice2() {
        return MAPPER.selWineByPrice2();
    }

    public List<WineTotalVo> selWineByPrice25() {
        return MAPPER.selWineByPrice25();
    }

    public List<WineTotalVo> selWineByPrice510() {
        return MAPPER.selWineByPrice510();
    }

    public List<WineTotalVo> selWineByPrice10() {
        return MAPPER.selWineByPrice10();
    }

    public List<WineTotalVo> selWineByCountry(WineSelByCountryDto dto) {
        return MAPPER.selWineByCountry(dto);
    }

    public List<WineFoodVo> selWineByFood(WineSelByFoodDto dto) {
        return MAPPER.selWineByFood(dto);
    }

    //6개씩 출력

}
