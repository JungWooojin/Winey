package com.team.winey.detail.model;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Data
public class SelReview {
    private Long productId;
    private int reviewCount;
}
