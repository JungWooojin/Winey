package com.team.winey.admin.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class UserVo {
    Long userId;
    String email;
    String nm;
    String regionNmId;
    String createdAt;
}
