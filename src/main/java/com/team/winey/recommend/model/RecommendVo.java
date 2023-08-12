package com.team.winey.recommend.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RecommendVo {
   private List<Long> productId;
}
