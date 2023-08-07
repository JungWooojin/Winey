package com.team.winey.detail;

import com.team.winey.detail.model.SelCountVo;
import com.team.winey.detail.model.SelSale;
import com.team.winey.detail.model.SelWineKorNm;
import com.team.winey.detail.model.WineDetailVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DetailMapper {
    WineDetailVo selWineDetail(Long productId);
    List<String> selPairing(Long productId);
    String selCount(SelCountVo vo);
    SelSale selSale(Long productId);
    SelWineKorNm selKorNm(Long productId);




}
