package com.team.winey.recommend.model;

import lombok.Data;

import java.util.List;

@Data
public class UserinfoDto {
    private Long userId;
    private List<Long> productId;
}

