package com.team.winey.detail;

import com.team.winey.detail.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DetailService {
    private final DetailMapper MAPPER;
    private final SelReview selReview;

    public WineVo selWineDetail(Long productId) {


        WineDetailVo vo = MAPPER.selWineDetail(productId);
        switch (vo.getTemp()) {
            case 0:
                vo.setTemp(10);
                break;
            case 1:
                vo.setTemp(15);
                break;
            default:
                vo.setTemp(18);
        }




        List<String> selPairing = MAPPER.selPairing(productId);


        List<String> selCount = new ArrayList();

        for (int i = 0; i < 3; i++) {
            SelCountVo selCountVo = new SelCountVo();
            selCountVo.setReviewLevel(i);
            selCountVo.setProductId(productId);
            MAPPER.selCount(selCountVo);
            selCount.add(MAPPER.selCount(selCountVo));

        }

        int level = 0;
        if(vo.getSweety() <= 2 && vo.getAcidity() <= 2 && vo.getBody() <= 2 ){
            level = 1;
        } else if(vo.getSweety() == 5 && vo.getAcidity() == 5 && vo.getBody() == 5 ){
            level = 3;
        } else {
            level = 2;
        }


        SelSale selSale = MAPPER.selSale(productId);
        if(selSale !=null){
            selSale.setProductId(productId);
            if( !"".equals(selSale.getSalePrice())){
                selSale.setSalePrice(vo.getPrice() - (vo.getPrice() * selSale.getSale() / 100));

            } else {
                selSale.setSalePrice(vo.getPrice());
            }

        } else if(selSale ==null) {
            selSale = null;
            log.info("할인상품아님");
        }



        return WineVo.builder()
                .wineDetailVo(vo)
                .selPairing(selPairing)
                .SelReview(selCount)
                .Level(level)
                .selSale(selSale)
                .build();

    }


    public SelWineKorNm selKorNm(Long productId) {
        return MAPPER.selKorNm(productId);
    }






}
