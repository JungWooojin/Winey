package com.team.winey.config.security.model;

import lombok.Data;

@Data
public class SignUpDto {
    private String email;
    private String pw;
    private String role;
    private String nm;
    private String tel;
    private Long regionNmId;
}
