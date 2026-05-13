package com.github.alym62.coupon.core.domain.enums;

public enum StatusCoupon {
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE");

    private final String value;

    StatusCoupon(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
