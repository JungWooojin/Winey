package com.team.winey.mypage.model;

import lombok.Data;

@Data
public class SelUserVo {
    private Long userId;
    private String email;
    private String pw;
    private String nm;
    private String tel;
    private Long regionNmId;
    private char delYn;
}
