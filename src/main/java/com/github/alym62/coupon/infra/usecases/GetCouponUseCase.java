package com.github.alym62.coupon.infra.usecases;

import com.github.alym62.coupon.core.domain.Coupon;
import com.github.alym62.coupon.core.exceptions.CouponDeletedException;
import com.github.alym62.coupon.core.exceptions.CouponNotFoundException;
import com.github.alym62.coupon.core.usecases.IGetCouponUseCase;
import com.github.alym62.coupon.infra.mappers.CouponMapper;
import com.github.alym62.coupon.infra.repository.CouponRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetCouponUseCase implements IGetCouponUseCase {
    private final CouponRepository couponRepository;

    public GetCouponUseCase(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    @Override
    public Coupon execute(UUID idCoupon) {
        return couponRepository.findById(idCoupon)
                .map(CouponMapper::persistenceToCoupon)
                .orElseThrow(() -> new CouponNotFoundException("Cupom não encontrado"));
    }
}
