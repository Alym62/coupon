package com.github.alym62.coupon.infra.usecases;

import com.github.alym62.coupon.core.domain.Coupon;
import com.github.alym62.coupon.core.domain.enums.StatusCoupon;
import com.github.alym62.coupon.core.exceptions.CouponDeletedException;
import com.github.alym62.coupon.core.usecases.IDeleteCouponUseCase;
import com.github.alym62.coupon.core.usecases.IGetCouponUseCase;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DeleteCouponUseCase implements IDeleteCouponUseCase {
    private final IGetCouponUseCase getCouponUseCase;

    public DeleteCouponUseCase(IGetCouponUseCase getCouponUseCase) {
        this.getCouponUseCase = getCouponUseCase;
    }

    @Override
    public Coupon execute(UUID idCoupon) {
        final Coupon couponForDelete = getCouponUseCase.execute(idCoupon);
        if (couponForDelete.getRemoved()) {
            throw new CouponDeletedException("O cupom já está deletado.");
        }

        couponForDelete.setRemoved(true);
        couponForDelete.setStatus(StatusCoupon.DELETED);
        return couponForDelete;
    }
}
