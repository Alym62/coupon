package com.github.alym62.coupon.core.exceptions;

public class ValidationException extends RuntimeException {
    private final String message;

    public ValidationException(final String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
