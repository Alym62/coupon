package com.github.alym62.coupon.core.usecases.impl;

import com.github.alym62.coupon.core.domain.Coupon;
import com.github.alym62.coupon.core.exceptions.CouponDeleted;
import com.github.alym62.coupon.core.gateway.CouponGateway;
import com.github.alym62.coupon.core.usecases.IDeleteCouponUseCase;

import java.util.UUID;

public class DeleteCouponUseCase implements IDeleteCouponUseCase {
    private final CouponGateway gateway;

    public DeleteCouponUseCase(CouponGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Coupon execute(UUID idCoupon) {
        final Coupon couponForDelete = gateway.getCouponById(idCoupon)
                .filter(coupon -> !coupon.getRemoved())
                .orElseThrow(() -> new CouponDeleted("O cupom já foi deletado."));
        return gateway.delete(couponForDelete.getId());
    }
}
