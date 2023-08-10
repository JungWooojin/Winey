package com.team.winey.wine;


import com.team.winey.wine.model.Match;
import com.team.winey.wine.model.WineInsDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WineMatchMapper {

    int insWine(WineInsDto dto);
    void saveMatch(Match match);
    List<Match> getAllMatches();

}