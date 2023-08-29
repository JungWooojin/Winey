package com.team.winey.search;

import com.team.winey.search.model.WineListVo;
import com.team.winey.search.model.WineSearchDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SearchMapper {

    List<WineListVo> searchWine(WineSearchDto dto);
    int selLastWine(WineSearchDto dto);
}
