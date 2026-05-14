package com.github.alym62.coupon.infra.mappers;

import com.github.alym62.coupon.core.domain.Coupon;
import com.github.alym62.coupon.infra.persistence.CouponPersistence;

public class CouponMapper {
    private CouponMapper() {
    }

    public static CouponPersistence couponToPersistence(final Coupon coupon) {
        return new CouponPersistence(
                coupon.getId(),
                coupon.getCode(),
                coupon.getDescription(),
                coupon.getDiscountValue(),
                coupon.getStatus(),
                coupon.getExpirationDate(),
                coupon.getPublished(),
                coupon.getRedeemed()
        );
    }

    public static Coupon persistenceToCoupon(final CouponPersistence persistence) {
        final Coupon coupon = new Coupon(
                persistence.getCode(),
                persistence.getDescription(),
                persistence.getDiscountValue(),
                persistence.getPublished(),
                persistence.getRedeemed(),
                persistence.getExpirationDate()
        );
        coupon.setId(persistence.getId());
        coupon.setStatus(persistence.getStatus());

        return coupon;
    }
}
