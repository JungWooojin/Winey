package com.team.winey.recommand.model;

import lombok.Data;

import java.util.List;

@Data
public class UserinfoDto {
    private Long userId;
    private List<Integer> productId;
}

