package com.team.winey.recommend.model;

import lombok.Data;

import java.util.List;

@Data
public class RecommendDto {
    private List<Long> categoryId;
    private List<Long> countryId;
    private List<Long> aromaId;
    private List<Long> smallCategoryId;
    private int priceRange;

}
