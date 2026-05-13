package com.github.alym62.coupon.core.usecases.impl;

import com.github.alym62.coupon.core.domain.Coupon;
import com.github.alym62.coupon.core.gateway.CouponGateway;
import com.github.alym62.coupon.core.usecases.IGetCouponUseCase;

import java.util.Optional;
import java.util.UUID;

public class GetCouponUseCase implements IGetCouponUseCase {
    private final CouponGateway gateway;

    public GetCouponUseCase(CouponGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Optional<Coupon> execute(UUID idCoupon) {
        return gateway.getCouponById(idCoupon);
    }
}
