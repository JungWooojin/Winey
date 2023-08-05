package com.team.winey.history.model;


import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReviewVo {
    private Long reviewId;
    private Long orderDetailId;
    private char reviewLevel;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
