package com.team.winey.admin.model;

import java.util.List;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductList {
    private PageDto page;
    private List<ProductVo> productList;
}
