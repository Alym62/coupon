package com.github.alym62.coupon.core.domain.vo;

import com.github.alym62.coupon.core.exceptions.ValidationException;

public record DescriptionCoupon(String value) {
    public DescriptionCoupon {
        /**
         * Validação do campo obrigatório
         */
        if (value == null || "".equalsIgnoreCase(value)) {
            throw new ValidationException("A descrição do cupom não pode ser nulo ou vazio.");
        }
    }
}
