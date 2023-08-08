package com.team.winey.main.model;

import lombok.Data;

@Data
public class WineFeatureVo {
    private Long productId;
    private Long featureId;
    private int sweety;
    private int acidity;
    private int body;
}
