package com.team.winey.config.security.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class UserEntity {
    private Long userId;
    private String email;
    private String pw;
    private String role;
    private String name;
    private int tosYn;
    private String tel;
    private LocalDateTime createdAt;
    private LocalDate updatedAt;
    private Long regionNmId;
//    private String secretKey;
}
