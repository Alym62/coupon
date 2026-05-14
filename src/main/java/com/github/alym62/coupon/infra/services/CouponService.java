package com.github.alym62.coupon.infra.services;

import com.github.alym62.coupon.application.dto.requests.CreateCouponRequestDto;
import com.github.alym62.coupon.application.dto.responses.CouponResponseDto;
import com.github.alym62.coupon.core.domain.Coupon;
import com.github.alym62.coupon.core.usecases.ICreateCouponUseCase;
import com.github.alym62.coupon.core.usecases.IDeleteCouponUseCase;
import com.github.alym62.coupon.core.usecases.IGetCouponUseCase;
import com.github.alym62.coupon.infra.mappers.CouponMapper;
import com.github.alym62.coupon.infra.persistence.CouponPersistence;
import com.github.alym62.coupon.infra.repository.CouponRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CouponService {
    private final ICreateCouponUseCase createCouponUseCase;
    private final IGetCouponUseCase getCouponUseCase;
    private final IDeleteCouponUseCase deleteCouponUseCase;
    private final CouponRepository couponRepository;

    public CouponService(ICreateCouponUseCase createCouponUseCase, IGetCouponUseCase getCouponUseCase, IDeleteCouponUseCase deleteCouponUseCase, CouponRepository couponRepository) {
        this.createCouponUseCase = createCouponUseCase;
        this.getCouponUseCase = getCouponUseCase;
        this.deleteCouponUseCase = deleteCouponUseCase;
        this.couponRepository = couponRepository;
    }

    @Transactional
    public CouponResponseDto createCoupon(CreateCouponRequestDto dto) {
        final Coupon couponEntity = createCouponUseCase.execute(dto.code(), dto.description(),
                dto.discountValue(), dto.expirationDate(), dto.published());

        return new CouponResponseDto(
                couponEntity.getId(),
                couponEntity.getCode(),
                couponEntity.getDescription(),
                couponEntity.getDiscountValue(),
                couponEntity.getExpirationDate(),
                couponEntity.getStatus().getValue(),
                couponEntity.getPublished(),
                couponEntity.getRedeemed()
        );
    }

    @Transactional
    public void deleteCoupon(UUID couponId) {
        final Coupon coupon = deleteCouponUseCase.execute(couponId);
        final CouponPersistence persistence = CouponMapper.couponToPersistence(coupon);

        couponRepository.save(persistence);
    }

    public CouponResponseDto getCouponById(UUID id) {
        final Coupon couponExists = getCouponUseCase.execute(id);
        final CouponPersistence persistence = CouponMapper.couponToPersistence(couponExists);

        return new CouponResponseDto(
                persistence.getId(),
                persistence.getCode(),
                persistence.getDescription(),
                persistence.getDiscountValue(),
                persistence.getExpirationDate(),
                persistence.getStatus().getValue(),
                persistence.getPublished(),
                persistence.getRedeemed()
        );
    }
}
