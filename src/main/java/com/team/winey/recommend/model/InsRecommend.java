package com.team.winey.recommend.model;

import lombok.Data;

@Data
public class InsRecommend {
    private Long userId;
    private Long categoryId;
    private Long countryId;
    private Long smallCategoryId;
    private Long priceRange;
    private Long aromaCategoryId;
}


