package com.github.alym62.coupon.core.domain;

import com.github.alym62.coupon.core.domain.enums.StatusCoupon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CouponTest {
    private static final LocalDateTime EXPIRATION_DATE = LocalDateTime.of(2027, 5, 20, 10, 30);
    private Coupon coupon;

    @BeforeEach
    void setUp() {
        this.coupon = new Coupon();
    }

    @Test
    void testConstructorNoParameters() {
        final Coupon coupon = new Coupon();
        assertNull(coupon.getCode());
    }

    @Test
    void testConstructorWithParametersValid() {
        final Coupon coupon = new Coupon("@ABC-123", "Descrição", 0.8, false, false, EXPIRATION_DATE);
        coupon.setId(UUID.randomUUID());
        assertNotNull(coupon.getCode());
        assertNotNull(coupon.getDescription());
        assertNotNull(coupon.getDiscountValue());
        assertNotNull(coupon.getExpirationDate());
        assertNotNull(coupon.getId());
        assertEquals(StatusCoupon.ACTIVE.getValue(), coupon.getStatus().getValue());
        assertFalse(coupon.getPublished());
        assertFalse(coupon.getRemoved());
        assertFalse(coupon.getRedeemed());
    }

    @Test
    void setUuid() {
        final UUID id = UUID.randomUUID();
        final Coupon coupon = new Coupon();
        coupon.setId(id);

        final UUID result = coupon.getId();
        assertNotNull(result);
    }

    @Test
    void addDescription() {
        final Coupon coupon = new Coupon();
        coupon.addDescription("desc");
        assertNotNull(coupon.getDescription());
        assertEquals("desc", coupon.getDescription());
    }

    @Test
    void addDiscountValue() {
        this.coupon.addDiscountValue(0.8);
        assertEquals(0.8, this.coupon.getDiscountValue());
    }

    @Test
    void setStatus() {
        this.coupon.setStatus(StatusCoupon.INACTIVE);
        assertEquals(StatusCoupon.INACTIVE.getValue(), this.coupon.getStatus().getValue());
    }

    @Test
    void setPublished() {
        this.coupon.setPublished(true);
        assertTrue(this.coupon.getPublished());
    }

    @Test
    void setRedeemed() {
        this.coupon.setRedeemed(true);
        assertTrue(this.coupon.getRedeemed());
    }

    @Test
    void addExpirationDate() {
        this.coupon.addExpirationDate(EXPIRATION_DATE);
        assertNotNull(this.coupon.getExpirationDate());
        assertEquals(2027, this.coupon.getExpirationDate().getYear());
    }

    @Test
    void addCodeCoupon() {
        this.coupon.addCodeCoupon("@ABR!!$123");
        assertNotNull(this.coupon.getCode());
        assertEquals("ABR123", this.coupon.getCode());
    }

    @Test
    void setRemoved() {
        this.coupon.setRemoved(true);
        assertTrue(this.coupon.getRemoved());
    }
}