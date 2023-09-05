package com.team.winey.admin.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfo {
    private Long userId;
    private String email;
    private String unm;
    private int sumOrderPrice;
    private int orderCount;
}
