package com.github.alym62.coupon.application.dto.responses;

import java.time.LocalDateTime;
import java.util.UUID;

public record CouponResponseDto(
        UUID id,
        String code,
        String description,
        Double discountValue,
        LocalDateTime expirationDate,
        String status,
        Boolean published,
        Boolean redeemed
) {
}
