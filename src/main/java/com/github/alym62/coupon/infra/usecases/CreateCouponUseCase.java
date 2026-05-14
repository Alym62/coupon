package com.github.alym62.coupon.infra.usecases;

import com.github.alym62.coupon.core.domain.Coupon;
import com.github.alym62.coupon.core.usecases.ICreateCouponUseCase;
import com.github.alym62.coupon.infra.mappers.CouponMapper;
import com.github.alym62.coupon.infra.persistence.CouponPersistence;
import com.github.alym62.coupon.infra.repository.CouponRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CreateCouponUseCase implements ICreateCouponUseCase {
    private final CouponRepository couponRepository;

    public CreateCouponUseCase(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    @Override
    public Coupon execute(String code, String description, Double discountValue, LocalDateTime expirationDate, Boolean published) {
        final Coupon couponEntity = new Coupon(code, description, discountValue, published, false, expirationDate);
        CouponPersistence persistence = CouponMapper.couponToPersistence(couponEntity);
        persistence = couponRepository.save(persistence);
        return CouponMapper.persistenceToCoupon(persistence);
    }
}
