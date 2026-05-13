package com.github.alym62.coupon.core.domain.vo;

import com.github.alym62.coupon.core.exceptions.ValidationException;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ExpirationDateCouponTest {
    private static final LocalDateTime EXPIRATION_DATE = LocalDateTime.of(2027, 5, 20, 10, 30);
    private static final LocalDateTime EXPIRATION_DATE_IS_BEFORE = LocalDateTime.of(2024, 5, 20, 10, 30);

    @Test
    void testInstanceExpirationDateCouponValid() {
        final ExpirationDateCoupon expirationDateCoupon = new ExpirationDateCoupon(EXPIRATION_DATE);
        assertEquals(EXPIRATION_DATE.getYear(), expirationDateCoupon.value().getYear());
    }

    @Test
    void testInstanceExpirationDateCouponWithValueNull() {
        final ValidationException exception = assertThrows(ValidationException.class, () -> {
            new ExpirationDateCoupon(null);
        });
        assertEquals("A data de expiração do cupom precisa ter um valor válido e não pode ser antes da data atual.", exception.getMessage());
    }

    @Test
    void testInstanceDiscountValueCouponWithValueLessThanValueMin() {
        final ValidationException exception = assertThrows(ValidationException.class, () -> {
            new ExpirationDateCoupon(EXPIRATION_DATE_IS_BEFORE);
        });
        assertEquals("A data de expiração do cupom precisa ter um valor válido e não pode ser antes da data atual.", exception.getMessage());
    }
}