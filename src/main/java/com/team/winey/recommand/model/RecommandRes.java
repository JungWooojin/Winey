package com.team.winey.recommand.model;

import lombok.Data;

import java.util.List;

@Data
public class RecommandRes {
    private List<Long> categoryId;
    private List<Long> countryId;
    private AromaDto aroma;
    private Long priceRange;
    private List<Long> smallCategoryId;
}
