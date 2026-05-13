package com.github.alym62.coupon.core.domain.vo;

import com.github.alym62.coupon.core.exceptions.ValidationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DescriptionCouponTest {
    @Test
    void testInstanceDescriptionCouponValid() {
        final DescriptionCoupon descriptionCoupon = new DescriptionCoupon("teste");
        assertEquals("teste", descriptionCoupon.value());
    }

    @Test
    void testInstanceDescriptionCouponWithValueNull() {
        final ValidationException exception = assertThrows(ValidationException.class, () -> {
            new DescriptionCoupon(null);
        });
        assertEquals("A descrição do cupom não pode ser nulo ou vazio.", exception.getMessage());
    }

    @Test
    void testInstanceDescriptionCouponWithValueEmpty() {
        final ValidationException exception = assertThrows(ValidationException.class, () -> {
            new DescriptionCoupon("");
        });
        assertEquals("A descrição do cupom não pode ser nulo ou vazio.", exception.getMessage());
    }
}