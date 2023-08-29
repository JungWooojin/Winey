package com.team.winey.main;

import com.team.winey.main.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
            if(vo.getSaleYn() == 0){
            vo.setSale(0);
            vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

    }

    public List<WineTotalVo> redWineByNew(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineTotalVo> wine = MAPPER.redWineByNew(dto);
        for (WineTotalVo vo : wine) {
            if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

    }

    public List<WineTotalVo> redWineByExpencive(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineTotalVo> wine = MAPPER.redWineByExpencive(dto);
        for (WineTotalVo vo : wine) {
            if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

    }

    public List<WineTotalVo> redWineByCheap(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineTotalVo> wine = MAPPER.redWineByCheap(dto);
        for (WineTotalVo vo : wine) {
            if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

    }

    //====================================================================

    public List<WineTotalVo> whiteWine(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineTotalVo> wine = MAPPER.whiteWine(dto);
        for (WineTotalVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

    }

    public List<WineTotalVo> whiteWineByNew(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineTotalVo> wine = MAPPER.whiteWineByNew(dto);
        for (WineTotalVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

    }

    public List<WineTotalVo> whiteWineByExpencive(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineTotalVo> wine = MAPPER.whiteWineByExpencive(dto);
        for (WineTotalVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

    }

    public List<WineTotalVo> whiteWineByCheap(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineTotalVo> wine = MAPPER.whiteWineByCheap(dto);
        for (WineTotalVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

    }

    //====================================================================

    public List<WineTotalVo> sparklingWine(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineTotalVo> wine = MAPPER.sparklingWine(dto);
        for (WineTotalVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;
    }

    public List<WineTotalVo> sparklingWineByNew(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineTotalVo> wine = MAPPER.sparklingWineByNew(dto);
        for (WineTotalVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

    }

    public List<WineTotalVo> sparklingWineByExpencive(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineTotalVo> wine = MAPPER.sparklingWineByExpencive(dto);
        for (WineTotalVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

    }

    public List<WineTotalVo> sparklingWineByCheap(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineTotalVo> wine = MAPPER.sparklingWineByCheap(dto);
        for (WineTotalVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

    }

    //====================================================================

    public List<WineTotalVo> otherWine(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineTotalVo> wine = MAPPER.otherWine(dto);
        for (WineTotalVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

    }

    public List<WineTotalVo> otherWineByNew(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineTotalVo> wine = MAPPER.otherWineByNew(dto);
        for (WineTotalVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

    }

    public List<WineTotalVo> otherWineByExpencive(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineTotalVo> wine = MAPPER.otherWineByExpencive(dto);
        for (WineTotalVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

    }

    public List<WineTotalVo> otherWineByCheap(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineTotalVo> wine = MAPPER.otherWineByCheap(dto);
        for (WineTotalVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;
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

        List<WineTotalVo> wine = MAPPER.selWine(dto);
        for (WineTotalVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

    }


    public List<WineTotalVo> selWineByNew(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineTotalVo> wine = MAPPER.selWineByNew(dto);
        for (WineTotalVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

    }

    public List<WineTotalVo> selWineByExpencive(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineTotalVo> wine = MAPPER.selWineByExpencive(dto);
        for (WineTotalVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

    }

    public List<WineTotalVo> selWineByCheap(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineTotalVo> wine = MAPPER.selWineByCheap(dto);
        for (WineTotalVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

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

        List<WineTotalVo> wine = MAPPER.selWineByPrice2(dto);
        for (WineTotalVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

    }

    public List<WineTotalVo> selWineByPrice2New(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineTotalVo> wine = MAPPER.selWineByPrice2New(dto);
        for (WineTotalVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

    }

    public List<WineTotalVo> selWineByPrice2Expencive(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineTotalVo> wine = MAPPER.selWineByPrice2Expencive(dto);
        for (WineTotalVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

    }

    public List<WineTotalVo> selWineByPrice2Cheap(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineTotalVo> wine = MAPPER.selWineByPrice2Cheap(dto);
        for (WineTotalVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;
    }
    //====================================================================

    public List<WineTotalVo> selWineByPrice25(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineTotalVo> wine = MAPPER.selWineByPrice25(dto);
        for (WineTotalVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;
    }

    public List<WineTotalVo> selWineByPrice25New(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        List<WineTotalVo> wine = MAPPER.selWineByPrice25New(dto);
        for (WineTotalVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

    }

    public List<WineTotalVo> selWineByPrice25Expencive(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        List<WineTotalVo> wine = MAPPER.selWineByPrice25Expencive(dto);
        for (WineTotalVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

    }

    public List<WineTotalVo> selWineByPrice25Cheap(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineTotalVo> wine = MAPPER.selWineByPrice25Cheap(dto);
        for (WineTotalVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

    }
    //====================================================================

    public List<WineTotalVo> selWineByPrice510(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineTotalVo> wine = MAPPER.selWineByPrice510(dto);
        for (WineTotalVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

    }

    public List<WineTotalVo> selWineByPrice510New(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineTotalVo> wine = MAPPER.selWineByPrice510New(dto);
        for (WineTotalVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

    }

    public List<WineTotalVo> selWineByPrice510Expencive(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineTotalVo> wine = MAPPER.selWineByPrice510Expencive(dto);
        for (WineTotalVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

    }

    public List<WineTotalVo> selWineByPrice510Cheap(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineTotalVo> wine = MAPPER.selWineByPrice510Cheap(dto);
        for (WineTotalVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

    }

    //====================================================================

    public List<WineTotalVo> selWineByPrice10(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineTotalVo> wine =  MAPPER.selWineByPrice10(dto);
        for (WineTotalVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

    }

    public List<WineTotalVo> selWineByPrice10New(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        List<WineTotalVo> wine = MAPPER.selWineByPrice10New(dto);
        for (WineTotalVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

    }

    public List<WineTotalVo> selWineByPrice10Expencive(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        List<WineTotalVo> wine = MAPPER.selWineByPrice10Expencive(dto);
        for (WineTotalVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

    }

    public List<WineTotalVo> selWineByPrice10Cheap(WineSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineTotalVo> wine = MAPPER.selWineByPrice10Cheap(dto);
        for (WineTotalVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

    }

    //===================================================================================
    public List<WineTotalVo> selWineByCountry(WineSelByCountryDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineTotalVo> wine = MAPPER.selWineByCountry(dto);
        for (WineTotalVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

    }

    public List<WineTotalVo> selWineByCountryNew(WineSelByCountryDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineTotalVo> wine = MAPPER.selWineByCountryNew(dto);
        for (WineTotalVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

    }

    public List<WineTotalVo> selWineByCountryExpencive(WineSelByCountryDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineTotalVo> wine = MAPPER.selWineByCountryExpencive(dto);
        for (WineTotalVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;
    }

    public List<WineTotalVo> selWineByCountryCheap(WineSelByCountryDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineTotalVo> wine = MAPPER.selWineByCountryCheap(dto);
        for (WineTotalVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

    }

//===================================================================================

    public List<WineFoodVo> selWineByFood(WineSelByFoodDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineFoodVo> wine = MAPPER.selWineByFood(dto);
        for (WineFoodVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

    }

    public List<WineFoodVo> selWineByFoodNew(WineSelByFoodDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineFoodVo> wine = MAPPER.selWineByFoodNew(dto);
        for (WineFoodVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

    }

    public List<WineFoodVo> selWineByFoodExpencive(WineSelByFoodDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineFoodVo> wine = MAPPER.selWineByFoodExpencive(dto);
        for (WineFoodVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;

    }

    public List<WineFoodVo> selWineByFoodCheap(WineSelByFoodDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());

        List<WineFoodVo> wine = MAPPER.selWineByFoodCheap(dto);
        for (WineFoodVo vo : wine) {
             if(vo.getSaleYn() == 0){
                vo.setSale(0);
                vo.setSalePrice(vo.getPrice());
            }
        }
        return wine;
    }
}
