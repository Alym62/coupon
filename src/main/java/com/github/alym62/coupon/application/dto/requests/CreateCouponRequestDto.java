package com.github.alym62.coupon.application.dto.requests;

import java.time.LocalDateTime;

public record CreateCouponRequestDto(
        String code,
        String description,
        Double discountValue,
        LocalDateTime expirationDate,
        Boolean published
) {
}
