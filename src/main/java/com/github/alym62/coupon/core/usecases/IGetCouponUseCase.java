package com.github.alym62.coupon.core.usecases;

import com.github.alym62.coupon.core.domain.Coupon;

import java.util.Optional;
import java.util.UUID;

public interface IGetCouponUseCase {
    Optional<Coupon> execute(UUID id);
}
