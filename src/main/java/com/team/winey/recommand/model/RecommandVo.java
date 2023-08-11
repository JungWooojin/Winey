package com.team.winey.recommand.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RecommandVo {
   private List<Long> productId;
}
