package com.github.alym62.coupon.core.gateway;

import com.github.alym62.coupon.core.domain.Coupon;

import java.util.Optional;
import java.util.UUID;

public interface CouponGateway {
    Coupon create(Coupon coupon);
    Optional<Coupon> getCouponById(UUID idCoupon);
    Coupon delete(UUID idCoupon);
}
