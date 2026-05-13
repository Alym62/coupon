package com.github.alym62.coupon.core.domain.vo;

import com.github.alym62.coupon.core.exceptions.ValidationException;

public record DiscountValueCoupon(Double value) {
    private static final Double DISCOUNT_VALUE_MIN = 0.5;

    public DiscountValueCoupon {
        /**
         * Validação do campo obrigatório e de valor mínimo atribuído
         */
        if (value == null || value < DISCOUNT_VALUE_MIN) {
            throw new ValidationException("O valor de desconto precisa ser válido. O valor minimo é 0.5");
        }
    }
}
