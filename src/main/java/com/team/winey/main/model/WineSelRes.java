package com.team.winey.main.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class WineSelRes {
    private Long productId;
    private int startIdx;
    private int size;
    List<WineListVo> list;
}
