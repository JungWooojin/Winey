package com.team.winey.search;

import com.team.winey.search.model.WineListVo;
import com.team.winey.search.model.WineSearchDto;
import com.team.winey.search.model.WineSelDetailRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final SearchMapper MAPPER;

    public WineSelDetailRes searchWine(WineSearchDto dto) {

        dto.setStartIdx((dto.getPage() - 1));
//        dto.setStartIdx((dto.getPage()-1) * dto.getRow());

        List<WineListVo> list = MAPPER.searchWine(dto);

        int count = MAPPER.selLastWine(dto);
        int maxPage = (int) Math.ceil((double) count / dto.getRow());
        int isMore = maxPage > dto.getPage() ? 1 : 0;

//        if(dto.getBigCategoryId() == null) {
//            return null;
//        }
//        if(dto.getCategoryId() == null) {
//            return null;
//        }
//        if(dto.getCountryId() == null) {
//            return null;
//        }

        return WineSelDetailRes.builder()
                .categoryId(dto.getCategoryId())
                .bigCategoryId(dto.getBigCategoryId())
                .countryId(dto.getCountryId())
                .text(dto.getText())
                .sort(dto.getSort())
                .price(dto.getPrice())
                .startIdx(dto.getStartIdx())
                .page(dto.getPage())
                .row(dto.getRow())
                .isMore(isMore)
                .maxPage(maxPage)
                .count(count)
                .wineList(list)
                .build();
    }
}
