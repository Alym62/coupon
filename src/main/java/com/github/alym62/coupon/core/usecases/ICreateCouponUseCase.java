package com.github.alym62.coupon.core.usecases;

import com.github.alym62.coupon.core.domain.Coupon;

import java.time.LocalDateTime;

public interface ICreateCouponUseCase {
    Coupon execute(String code, String description, Double discountValue, LocalDateTime expirationDate, Boolean published);
}
