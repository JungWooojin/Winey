package com.team.winey.admin.model;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserVo {
    Long userId;
    String email;
    String nm;
    int regionNmId;
}
