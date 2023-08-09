package com.team.winey.recommand;


import com.team.winey.recommand.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "사용자맞춤와인추천")
@Slf4j
@RestController
@RequestMapping("/api/recommand")
@RequiredArgsConstructor
public class RecommandController {
    private final RecommandService service;


    @GetMapping
    @Operation(summary = "사용자 추천설정", description =
            "categoryId:와인종류 1:레드와인, 2:화이트와인, 3:스파클링와인, 4:기타 ex) 1번과 3번하려면 1누르고 add누르고 3입력해야하며 생략또한 가능 <br>" +
                    "countryId: 원산지 1:미국, 2:스페인, 3:이탈리아, 4:칠레, 5:포르투갈, 6:프랑스 ex: categoryId입력방법과 동일<br>" +
                    "smallcategoryId: 페어링음식 12번까지있으며 1:steak, 2:chicken, 3:lamb, 4:pork, 5:oyster, 6:fish, 7:shrimp, 8:clamp, 9:cheeze, 10:fruit, 11:pizza, 12:pasta ex: categoryId입력방법과 동일 <br>" +
                    "priceRange: 가격범위 입력시 1번부터 5번까지 있으며 입력시에 1:2만원미만, 2:2만원이상 5만원미만, 3:5만원이상 10만원미만, 4:10만원이상, 5: 아무거나를 뜻합니다. ex) 3 "+
                    "aroma: 향기 스킵이 가능하고 입력시에 각 이름에 0이면 향없음 1이면 향있음입니다. ex) flower:0,plant:1,fruit:0, spicy:1, earth:0, oak:1, nuts:0 "
    )
    public List<Integer> getCountry(@RequestParam(required = false) List<Long> categoryId,
                                    @RequestParam(required = false) List<Long> countryId,
                                    @RequestParam(required = false) List<Long> smallcategoryId,
                                    @RequestParam(required = false) Long priceRange,
                                    AromaDto aroma) {
            RecommandRes res = new RecommandRes();
            res.setCountryId(countryId);
            res.setCategoryId(categoryId);
            res.setAroma(aroma);
            res.setPriceRange(priceRange);
            res.setSmallCategoryId(smallcategoryId);
        return service.selRecommand(res);
    }

}

