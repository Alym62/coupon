package com.github.alym62.coupon.core.usecases;

import com.github.alym62.coupon.core.domain.Coupon;

import java.util.UUID;

public interface IGetCouponUseCase {
    Coupon execute(UUID id);
}
