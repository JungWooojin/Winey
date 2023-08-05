package com.team.winey.sign.model;

import lombok.Data;

@Data
public class SignUpResultDto {
    private boolean success;
    private int code;
    private String msg;
}
