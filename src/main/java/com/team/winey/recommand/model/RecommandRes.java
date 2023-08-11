package com.team.winey.recommand.model;

import lombok.Data;

import java.util.List;

@Data
public class RecommandRes {
    private List<Long> categoryId;
    private List<Long> countryId;
    private List<Long> smallCategoryId;
    private Long flower ;
    private Long plant ;
    private Long fruit ;
    private Long spicy;
    private Long earth ;
    private Long oak ;
    private Long nuts ;
    private Long priceRange;
}
