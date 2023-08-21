package com.team.winey.main;

import com.team.winey.file.FileMapper;
import com.team.winey.main.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MainService {

    private final MainMapper MAPPER;

    public List<WineTotalVo> redWine(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineTotalVo> wine = MAPPER.redWine(dto);
        for (WineTotalVo vo : wine) {
            if(vo.getSaleYn() == 0)
            vo.setSale(0);
            vo.setSalePrice(vo.getPrice());
        }
        return wine;

    }

    public List<WineTotalVo> redWineByNew(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.redWineByNew(dto);
    }

    public List<WineTotalVo> redWineByExpencive(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.redWineByExpencive(dto);
    }

    public List<WineTotalVo> redWineByCheap(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.redWineByCheap(dto);
    }

    //====================================================================

    public List<WineTotalVo> whiteWine(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.whiteWine(dto);
    }

    public List<WineTotalVo> whiteWineByNew(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.whiteWineByNew(dto);
    }

    public List<WineTotalVo> whiteWineByExpencive(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.whiteWineByExpencive(dto);
    }

    public List<WineTotalVo> whiteWineByCheap(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.whiteWineByCheap(dto);
    }

    //====================================================================

    public List<WineTotalVo> sparklingWine(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.sparklingWine(dto);
    }

    public List<WineTotalVo> sparklingWineByNew(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.sparklingWineByNew(dto);
    }

    public List<WineTotalVo> sparklingWineByExpencive(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.sparklingWineByExpencive(dto);
    }

    public List<WineTotalVo> sparklingWineByCheap(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.sparklingWineByCheap(dto);
    }

    //====================================================================

    public List<WineTotalVo> otherWine(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.otherWine(dto);
    }

    public List<WineTotalVo> otherWineByNew(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.otherWineByNew(dto);
    }

    public List<WineTotalVo> otherWineByExpencive(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.otherWineByExpencive(dto);
    }

    public List<WineTotalVo> otherWineByCheap(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.otherWineByCheap(dto);
    }

    //====================================================================

    // 금액 10원단위 절삭
    public List<WineTotalVo> selWinePrice() {
        List<WineTotalVo> voList = MAPPER.selWinePrice();

        for (WineTotalVo vo : voList) {
            double originalPrice = vo.getPrice();
            int ceilPrice = (int) Math.ceil(originalPrice / 100) * 100;

            WineUpdDto dto = new WineUpdDto();
            dto.setProductId(vo.getProductId());
            dto.setPrice(ceilPrice);
            MAPPER.updPrice(dto);
        }

        return MAPPER.selWinePrice();
    }

    //더미데이터 세일금액으로 변경
    public List<WineTotalVo> selWineSalePrice() {
        List<WineTotalVo> voList = MAPPER.selWinePrice();

        for (WineTotalVo vo : voList) {
            double originalPrice = vo.getPrice();
            int sale = vo.getSale();
            int salePrice = (int) Math.ceil(originalPrice-(originalPrice / sale));
            int ceilPrice = (int) Math.ceil(salePrice / 100) * 100;

            WineUpdSalePriceDto dto = new WineUpdSalePriceDto();
            dto.setProductId(vo.getProductId());
            dto.setSalePrice(ceilPrice);
            MAPPER.updSalePrice(dto);
        }

        return MAPPER.selWinePrice();
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
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.selWineByCountry(dto);
    }

    public List<WineTotalVo> selWineByCountryNew(WineSelByCountryDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.selWineByCountryNew(dto);
    }

    public List<WineTotalVo> selWineByCountryExpencive(WineSelByCountryDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.selWineByCountryExpencive(dto);
    }

    public List<WineTotalVo> selWineByCountryCheap(WineSelByCountryDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.selWineByCountryCheap(dto);
    }

//===================================================================================

    public List<WineFoodVo> selWineByFood(WineSelByFoodDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.selWineByFood(dto);
    }

    public List<WineFoodVo> selWineByFoodNew(WineSelByFoodDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.selWineByFoodNew(dto);
    }

    public List<WineFoodVo> selWineByFoodExpencive(WineSelByFoodDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.selWineByFoodExpencive(dto);
    }

    public List<WineFoodVo> selWineByFoodCheap(WineSelByFoodDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return MAPPER.selWineByFoodCheap(dto);
    }
}
