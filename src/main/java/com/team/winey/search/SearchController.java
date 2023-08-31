package com.team.winey.search;


import com.team.winey.search.model.WineSearchDto;
import com.team.winey.search.model.WineSelDetailRes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Tag(name = "와인 검색")
@RestController
@RequestMapping("/api/search")
@RequiredArgsConstructor
public class SearchController {

    private final SearchService SERVICE;

    @GetMapping()
    @Operation(summary = "와인 검색"
            , description = "" +
            "\"cate\": [-] 와인 카테고리(1: 레드, 2: 화이트, 3: 스파클링, 4: 기타),<br>" +
            "\"bigCate\": [-] 음식 카테고리(1: meet, 2: seafood, 3: otherfood),<br>" +
            "\"country\": [-] 나라 카테고리(1: 미국, 3: 프랑스, 4: 이탈리아, 6: 칠레 , 그 외 (2, 5): 기타),<br>" +
            "\"text\": [-] 검색어,<br>" +
            "\"page\": [-] 리스트 페이지,<br>" +
            "\"row\": [고정] 아이템 개수,<br>" +
            "\"sort\": [1] 판매순 랭킹(0 : 오래된순, 1: 최신순, 2: 높은가격순, 3: 낮은가격순)  <br>" +
            "\"price\": [1] 금액별 순서(0: 전체금액, 1 : 2만원 미만, 2: 2~5만원 , 3: 5~10만원, 4: 10만원 이상)  <br>"
    )
    public WineSelDetailRes getSearchWine(@RequestParam(value = "cate", required = false) Long cate,
                                          @RequestParam(value = "bigCate", required = false) Long bigCate,
                                          @RequestParam(value = "country", required = false) Long country,
                                          @RequestParam(value = "text", required = false) String text,
                                          @RequestParam(defaultValue = "1") int page,
                                          @RequestParam(defaultValue = "9") int row,
                                          @RequestParam(defaultValue = "0", required = false) int sort,
                                          @RequestParam(defaultValue = "0", required = false) int price) {

        WineSearchDto dto = new WineSearchDto();
        dto.setText(text);
        dto.setPage(page);
        dto.setRow(row);
        dto.setCategoryId(cate);
        dto.setBigCategoryId(bigCate);
        dto.setCountryId(country);
        dto.setSort(sort);
        dto.setPrice(price);

        return SERVICE.searchWine(dto);
    }}
