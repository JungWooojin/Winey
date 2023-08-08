package com.team.winey.recommand.model;

import lombok.Data;

import java.util.List;

@Data
public class RecommandDto {
    private List<Long> categoryId;
    private List<Long> countryId;
    private List<Long> aromaId;
    private List<Long> smallCategoryId;
    private int priceRange;

}
