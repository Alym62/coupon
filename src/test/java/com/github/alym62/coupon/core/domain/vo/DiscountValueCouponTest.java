package com.github.alym62.coupon.core.domain.vo;

import com.github.alym62.coupon.core.exceptions.ValidationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountValueCouponTest {
    @Test
    void testInstanceDiscountValueCouponValid() {
        final DiscountValueCoupon discountValueCoupon = new DiscountValueCoupon(0.8);
        assertEquals(0.8, discountValueCoupon.value());
    }

    @Test
    void testInstanceDiscountValueCouponWithValueNull() {
        final ValidationException exception = assertThrows(ValidationException.class, () -> {
            new DiscountValueCoupon(null);
        });
        assertEquals("O valor de desconto precisa ser válido. O valor minimo é 0.5", exception.getMessage());
    }

    @Test
    void testInstanceDiscountValueCouponWithValueLessThanValueMin() {
        final ValidationException exception = assertThrows(ValidationException.class, () -> {
            new DiscountValueCoupon(0.3);
        });
        assertEquals("O valor de desconto precisa ser válido. O valor minimo é 0.5", exception.getMessage());
    }
}