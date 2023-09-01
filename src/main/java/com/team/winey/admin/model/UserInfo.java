package com.team.winey.admin.model;

import lombok.Getter;

@Getter
public class UserInfo {
    private Long userId;
    private String email;
    private String nm;
    private int sumOrderPrice;
    private int orderCount;
}
