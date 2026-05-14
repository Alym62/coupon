package com.github.alym62.coupon.infra.repository;

import com.github.alym62.coupon.infra.persistence.CouponPersistence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CouponRepository extends JpaRepository<CouponPersistence, UUID> {
}
