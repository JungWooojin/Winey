package com.team.winey.admin.model;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductList {
    private PageDto page;
    private List<ProductVo> productList;
}
