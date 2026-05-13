package com.github.alym62.coupon.core.usecases.impl;

import com.github.alym62.coupon.core.domain.Coupon;
import com.github.alym62.coupon.core.gateway.CouponGateway;
import com.github.alym62.coupon.core.usecases.ICreateCouponUseCase;

import java.time.LocalDateTime;

public class CreateCouponUseCase implements ICreateCouponUseCase {
    private final CouponGateway gateway;

    public CreateCouponUseCase(CouponGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Coupon execute(String code, String description, Double discountValue, LocalDateTime expirationDate, Boolean published) {
        final Coupon coupon = new Coupon(code, description, discountValue, published, false, expirationDate);
        return gateway.create(coupon);
    }
}
