package com.github.alym62.coupon.core.exceptions;

public class CouponNotFoundException extends CouponException {
    private final String message;

    public CouponNotFoundException(final String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
