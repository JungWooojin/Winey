package com.team.winey.recommend.model;

import lombok.Data;

import java.util.List;

@Data
public class SelUserRecommnadVo {
    private List<Long> categoryId;
    private List<Long> countryId;
    private List<Long> smallCategoryId;
    private List<Long> priceRange;
    private Long flower ;
    private Long plant ;
    private Long fruit ;
    private Long spicy;
    private Long earth ;
    private Long oak ;
    private Long nuts ;
}

