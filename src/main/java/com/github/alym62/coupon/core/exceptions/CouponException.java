package com.github.alym62.coupon.core.exceptions;

public abstract class CouponException extends RuntimeException {
    public CouponException(String message) {
        super(message.isBlank() ? "Erro interno de servidor. Entre em contato com o suporte." : message);
    }
}
