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

        for (int i = 1; i <= 3; i++) {
            SelCountVo selCountVo = new SelCountVo();
            selCountVo.setReviewLevel(i);
            selCountVo.setProductId(productId);
            MAPPER.selCount(selCountVo);
            selCount.add(MAPPER.selCount(selCountVo));
        }



        SelAroma selAroma = MAPPER.selAroma(productId);

        List<SelAroma> aromaList = new ArrayList<>();
        List<String> aroma = new ArrayList<>();
        aromaList.add(selAroma);

        for (SelAroma aromaItem : aromaList) {
            if (aromaItem.getFlower() == 1) {
                aroma.add("flower");
            }
            if (aromaItem.getPlant() == 1) {
                aroma.add("plant");
            }
            if (aromaItem.getOak() == 1) {
                aroma.add("Oak");
            }
            if (aromaItem.getNuts() == 1) {
                aroma.add("Nuts");
            }
            if (aromaItem.getFruit() == 1) {
                aroma.add("Fruit");
            }
            if (aromaItem.getSpicy() == 1) {
                aroma.add("Spicy");
            }
            if (aromaItem.getEarth() == 1) {
                aroma.add("Earth");
            }
            log.info("aroma : {}", aroma);

        }

//        SelAroma selAroma = MAPPER.selAroma(productId);
//        List<SelAroma> map = new ArrayList<>();
//        List<String> aroma = new ArrayList<>();
//        map.add(selAroma);
//        System.out.println(map);
//
//        for (int i = 0; i < map.size(); i++) {
//
//            if("1".equals(map.get(i))) {
//                aroma.add(map.get(i).toString());
//            }
//
//        }





        int level = 0;
        int sum = vo.getSweety() + vo.getAcidity() + vo.getBody();

        if (sum < 8) {
            level = 1;
        } else if (sum >= 8 && sum < 11) {
            level = 2;
        } else if (sum >= 11 && sum < 16) {
            level = 3;
        }

//        return -1;
//        if(vo.getSweety() <= 2 && vo.getAcidity() <= 2 && vo.getBody() <= 2 ){
//            level = 1;
//        } else if(vo.getSweety() == 5 && vo.getAcidity() == 5 && vo.getBody() == 5 ){
//            level = 3;
//        } else {
//            level = 2;
//        }


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
                .selReview(selCount)
                .selAroma(aroma)
                .Level(level)
                .selSale(selSale)
                .build();

    }


    public SelWineKorNm selKorNm(Long productId) {
        return MAPPER.selKorNm(productId);
    }






}
