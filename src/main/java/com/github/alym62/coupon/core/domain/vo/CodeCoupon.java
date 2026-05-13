package com.github.alym62.coupon.core.domain.vo;

import com.github.alym62.coupon.core.exceptions.ValidationException;

public record CodeCoupon(String value) {
    private static final int LENGTH = 6;

    public CodeCoupon {
        /**
         * Validação do campo obrigatório
         */
        if (value == null || "".equalsIgnoreCase(value)) {
            throw new ValidationException("Código do cupom não pode ser nulo.");
        }

        /**
         * Remoção de caracteres especiais
         */
        String cleaned = value.replaceAll("[^a-zA-Z0-9]", "").toUpperCase();

        /**
         * Tamanho padrão do código do cupom
         */
        if (cleaned.length() != LENGTH) {
            throw new ValidationException(
                    "Código do cupom deve ter %d caracteres alfanuméricos (recebido: '%s' → '%s')"
                            .formatted(LENGTH, value, cleaned)
            );
        }
    }
}
