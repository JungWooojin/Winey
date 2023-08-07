package com.team.winey.admin;

import com.team.winey.admin.model.ProductAromaDto;
import com.team.winey.admin.model.ProductInsDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {

    int insProduct(ProductInsDto dto);
    int insFeature(ProductInsDto dto);
    int insAroma(ProductAromaDto dto);
    int insSale(ProductInsDto dto);
    int insWinePairing(ProductInsDto dto);
}
