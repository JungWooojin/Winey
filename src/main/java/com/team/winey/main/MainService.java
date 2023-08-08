package com.team.winey.main;

import com.team.winey.main.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainService {

    private final MainMapper MAPPER;

    public int selFeature(WineFeatureDto dto) {
        WineFeatureVo result = MAPPER.beginners(dto);

        if (result.getSweety() <= 2 && result.getAcidity() <= 2 && result.getBody() <= 2) {
            return 1;
        } else if (result.getSweety() <= 4 && result.getSweety() > 2 || result.getAcidity() <= 4 && result.getAcidity() > 2
                    || result.getBody() <= 4 && result.getBody() > 2) {
            return 2;
        } else if (result.getSweety() > 4 && result.getAcidity() > 4 && result.getBody() > 4){
            return 3;
        }
        return -1;
    }

    public List<WineTotalVo> selWine(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.selWine(dto);
    }

    public List<WineTotalVo> selWineByNew(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.selWineByNew(dto);
    }

    public List<WineTotalVo> selWineByExpencive(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.selWineByExpencive(dto);
    }

    public List<WineTotalVo> selWineByCheap(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.selWineByCheap(dto);
    }

    //    public List<WineVo> selWineByPrice(WineSelByPriceDto dto) {
//        return MAPPER.selWineByPrice(dto);
//    }

    public WineTotalVo selWineById(WineSelDetailDto dto) {
        return MAPPER.selWineById(dto);
    }
    //====================================================================

    public List<WineTotalVo> selWineByPrice2(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.selWineByPrice2(dto);
    }

    public List<WineTotalVo> selWineByPrice2New(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.selWineByPrice2New(dto);
    }

    public List<WineTotalVo> selWineByPrice2Expencive(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.selWineByPrice2Expencive(dto);
    }

    public List<WineTotalVo> selWineByPrice2Cheap(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.selWineByPrice2Cheap(dto);
    }
    //====================================================================

    public List<WineTotalVo> selWineByPrice25(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.selWineByPrice25(dto);
    }

    public List<WineTotalVo> selWineByPrice25New(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.selWineByPrice25New(dto);
    }

    public List<WineTotalVo> selWineByPrice25Expencive(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.selWineByPrice25Expencive(dto);
    }

    public List<WineTotalVo> selWineByPrice25Cheap(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.selWineByPrice25Cheap(dto);
    }
    //====================================================================

    public List<WineTotalVo> selWineByPrice510(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.selWineByPrice510(dto);
    }

    public List<WineTotalVo> selWineByPrice510New(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.selWineByPrice510New(dto);
    }

    public List<WineTotalVo> selWineByPrice510Expencive(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.selWineByPrice510Expencive(dto);
    }

    public List<WineTotalVo> selWineByPrice510Cheap(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.selWineByPrice510Cheap(dto);
    }

    //====================================================================

    public List<WineTotalVo> selWineByPrice10(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.selWineByPrice10(dto);
    }

    public List<WineTotalVo> selWineByPrice10New(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.selWineByPrice10New(dto);
    }

    public List<WineTotalVo> selWineByPrice10Expencive(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.selWineByPrice10Expencive(dto);
    }

    public List<WineTotalVo> selWineByPrice10Cheap(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.selWineByPrice10Cheap(dto);
    }

    //===================================================================================
    public List<WineTotalVo> selWineByCountry(WineSelByCountryDto dto) {
        return MAPPER.selWineByCountry(dto);
    }

    public List<WineTotalVo> selWineByCountryNew(WineSelByCountryDto dto) {
        return MAPPER.selWineByCountryNew(dto);
    }

    public List<WineTotalVo> selWineByCountryExpencive(WineSelByCountryDto dto) {
        return MAPPER.selWineByCountryExpencive(dto);
    }

    public List<WineTotalVo> selWineByCountryCheap(WineSelByCountryDto dto) {
        return MAPPER.selWineByCountryCheap(dto);
    }

//===================================================================================

    public List<WineTotalVo> selWineByFood(WineSelByFoodDto dto) {
        return MAPPER.selWineByFood(dto);
    }

    public List<WineTotalVo> selWineByFoodNew(WineSelByFoodDto dto) {
        return MAPPER.selWineByFoodNew(dto);
    }

    public List<WineTotalVo> selWineByFoodExpencive(WineSelByFoodDto dto) {
        return MAPPER.selWineByFoodExpencive(dto);
    }

    public List<WineTotalVo> selWineByFoodCheap(WineSelByFoodDto dto) {
        return MAPPER.selWineByFoodCheap(dto);
    }
}
