package com.team.winey.admin.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserRefundVo {
    private int userId;
    private int sumOrderPrice;
    private int orderCount;
}
