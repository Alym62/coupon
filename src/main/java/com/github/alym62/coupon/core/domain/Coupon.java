package com.github.alym62.coupon.core.domain;

import com.github.alym62.coupon.core.domain.enums.StatusCoupon;
import com.github.alym62.coupon.core.domain.vo.CodeCoupon;
import com.github.alym62.coupon.core.domain.vo.DescriptionCoupon;
import com.github.alym62.coupon.core.domain.vo.DiscountValueCoupon;
import com.github.alym62.coupon.core.domain.vo.ExpirationDateCoupon;

import java.time.LocalDateTime;
import java.util.UUID;

public class Coupon {
    private UUID id;
    private String code;
    private String description;
    private Double discountValue;
    private StatusCoupon status;
    private LocalDateTime expirationDate;
    private Boolean published;
    private Boolean redeemed;
    private Boolean removed;

    public Coupon() {}

    public Coupon(String code, String description, Double discountValue, Boolean published,
                  Boolean redeemed, LocalDateTime expirationDate) {
        /**
         * CodeCoupon é um ValueObject com toda regra de negócio embutida nele seguindo os principios do DDD.
         */
        final CodeCoupon codeCoupon = new CodeCoupon(code);
        this.code = codeCoupon.value();

        /**
         * DiscountValueCoupon é um ValueObject com toda regra de negócio embutida nele seguindo os principios do DDD.
         */
        final DiscountValueCoupon discountValueCouponVo = new DiscountValueCoupon(discountValue);
        this.discountValue = discountValueCouponVo.value();

        /**
         * DescriptionCoupon é um ValueObject com toda regra de negócio embutida nele seguindo os principios do DDD.
         */
        final DescriptionCoupon descriptionCoupon = new DescriptionCoupon(description);
        this.description = descriptionCoupon.value();

        /**
         * ExpirationDateCoupon é um ValueObject com toda regra de negócio embutida nele seguindo os principios do DDD.
         */
        final ExpirationDateCoupon expirationDateCoupon = new ExpirationDateCoupon(expirationDate);
        this.expirationDate = expirationDateCoupon.value();

        this.status = StatusCoupon.ACTIVE;
        this.published = published;
        this.redeemed = redeemed;
        this.removed = false;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public void addDescription(String description) {
        final DescriptionCoupon descriptionCoupon = new DescriptionCoupon(description);
        this.description = descriptionCoupon.value();
    }

    public Double getDiscountValue() {
        return discountValue;
    }

    public void addDiscountValue(Double discountValue) {
        final DiscountValueCoupon discountValueCoupon = new DiscountValueCoupon(discountValue);
        this.discountValue = discountValueCoupon.value();
    }

    public StatusCoupon getStatus() {
        return status;
    }

    public void setStatus(StatusCoupon status) {
        this.status = status;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public Boolean getRedeemed() {
        return redeemed;
    }

    public void setRedeemed(Boolean redeemed) {
        this.redeemed = redeemed;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public Boolean getRemoved() {
        return removed;
    }

    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }

    public void addExpirationDate(LocalDateTime expirationDate) {
        final ExpirationDateCoupon expirationDateCoupon = new ExpirationDateCoupon(expirationDate);
        this.expirationDate = expirationDateCoupon.value();
    }

    public void addCodeCoupon(String code) {
        final CodeCoupon codeCoupon = new CodeCoupon(code);
        this.code = codeCoupon.value();
    }
}
