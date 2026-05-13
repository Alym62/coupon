package com.github.alym62.coupon.core.domain.vo;

import com.github.alym62.coupon.core.exceptions.ValidationException;

import java.time.LocalDateTime;

public record ExpirationDateCoupon(LocalDateTime value) {
    public ExpirationDateCoupon {
        /**
         * Validação do campo obrigatório e de expiração não ser antes da data atual
         */
        if (value == null || value.isBefore(LocalDateTime.now())) {
            throw new ValidationException("A data de expiração do cupom precisa ter um valor válido e não pode ser antes da data atual.");
        }
    }
}
