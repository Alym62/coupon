package com.github.alym62.coupon.core.domain.vo;

import com.github.alym62.coupon.core.exceptions.ValidationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodeCouponTest {
    @Test
    void testInstanceCodeCouponValid() {
        final CodeCoupon codeCoupon = new CodeCoupon("*&$#@ABC-123!!!");
        assertEquals("ABC123", codeCoupon.value());
    }

    @Test
    void testInstanceCodeCouponWithValueNull() {
        final ValidationException exception = assertThrows(ValidationException.class, () -> {
            new CodeCoupon(null);
        });
        assertEquals("Código do cupom não pode ser nulo.", exception.getMessage());
    }

    @Test
    void testInstanceCodeCouponWithValueEmpty() {
        final ValidationException exception = assertThrows(ValidationException.class, () -> {
            new CodeCoupon("");
        });
        assertEquals("Código do cupom não pode ser nulo.", exception.getMessage());
    }

    @Test
    void testInstanceCodeCouponWithValueLengthEqualsSeven() {
        final ValidationException exception = assertThrows(ValidationException.class, () -> {
            new CodeCoupon("!!!ABC%¨&1234");
        });
        assertEquals("Código do cupom deve ter 6 caracteres alfanuméricos (recebido: '!!!ABC%¨&1234' → 'ABC1234')", exception.getMessage());
    }
}