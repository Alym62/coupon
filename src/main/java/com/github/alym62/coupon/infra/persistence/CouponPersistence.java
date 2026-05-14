package com.github.alym62.coupon.infra.persistence;

import com.github.alym62.coupon.core.domain.enums.StatusCoupon;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_coupons")
public class CouponPersistence {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "coupon_id")
    private UUID id;

    @Column(name = "code_coupon", nullable = false, length = 6)
    private String code;

    @Column(name = "description", nullable = false, length = 120)
    private String description;

    @Column(name = "discount_value", nullable = false)
    private Double discountValue;

    @Column(name = "status_coupon", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusCoupon status;

    @Column(name = "expiration_date", nullable = false, updatable = false)
    private LocalDateTime expirationDate;

    @Column(name = "published")
    private Boolean published;

    @Column(name = "redeemed")
    private Boolean redeemed;

    @Column(name = "removed")
    private Boolean removed;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @PrePersist
    void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.deletedAt = LocalDateTime.now();
        this.removed = false;
        this.redeemed = false;
    }

    @PreUpdate
    void preUpdate() {
        this.updatedAt = LocalDateTime.now();
        this.deletedAt = LocalDateTime.now();
        this.removed = true;
    }

    public CouponPersistence() {}

    public CouponPersistence(UUID id, String code, String description, Double discountValue, StatusCoupon status,
                             LocalDateTime expirationDate, Boolean published, Boolean redeemed) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.discountValue = discountValue;
        this.status = status;
        this.expirationDate = expirationDate;
        this.published = published;
        this.redeemed = redeemed;
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

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(Double discountValue) {
        this.discountValue = discountValue;
    }

    public StatusCoupon getStatus() {
        return status;
    }

    public void setStatus(StatusCoupon status) {
        this.status = status;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
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

    public Boolean getRemoved() {
        return removed;
    }

    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
