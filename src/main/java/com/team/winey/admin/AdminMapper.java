package com.team.winey.admin;

import com.team.winey.admin.model.ProductAromaDto;
import com.team.winey.admin.model.ProductInsDto;
import com.team.winey.admin.model.ProductUpdDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {

    //상품 등록
    int insProduct(ProductInsDto dto);
    int insFeature(ProductInsDto dto);
    int insAroma(ProductAromaDto dto);
    int insSale(ProductInsDto dto);
    int insWinePairing(ProductInsDto dto);

    //상품 수정
    ProductUpdDto selProductFk(int productId); // 특정 product의 FK값 구하기

    int updFeature(ProductUpdDto dto);
    int updAroma(ProductAromaDto dto);
    int updSale(ProductUpdDto dto);
    int delWinePairing(ProductUpdDto dto);
    int updProduct(ProductUpdDto dto);
}
