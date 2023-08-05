package com.team.winey.config.security.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserTokenEntity {
    private Long userId;
    private String ip;
    private String accessToken;
    private String refreshToken;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
