package com.team.winey.detail.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class SelReview {
    private Long productId;
    private int reviewCount;
}
