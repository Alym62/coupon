package com.github.alym62.coupon.application.config;

import com.github.alym62.coupon.core.exceptions.CouponDeletedException;
import com.github.alym62.coupon.core.exceptions.CouponException;
import com.github.alym62.coupon.core.exceptions.CouponNotFoundException;
import com.github.alym62.coupon.core.exceptions.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler(CouponException.class)
    public ProblemDetail couponException(CouponException exception) {
        final ProblemDetail pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        pb.setTitle("Entre em contato com nosso suporte.");
        pb.setDetail(exception.getMessage());

        return pb;
    }

    @ExceptionHandler(Exception.class)
    public ProblemDetail exception(Exception exception) {
        final ProblemDetail pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        pb.setTitle("Entre em contato com nosso suporte.");

        return pb;
    }

    @ExceptionHandler(CouponDeletedException.class)
    public ProblemDetail couponDeletedException(CouponDeletedException exception) {
        final ProblemDetail pb = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        pb.setTitle("Não foi possível deletar o cupom desejado.");
        pb.setDetail(exception.getMessage());

        return pb;
    }

    @ExceptionHandler(CouponNotFoundException.class)
    public ProblemDetail couponNotFoundException(CouponNotFoundException exception) {
        final ProblemDetail pb = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        pb.setTitle("Não foi possível encontrar o cupom desejado.");
        pb.setDetail(exception.getMessage());

        return pb;
    }

    @ExceptionHandler(ValidationException.class)
    public ProblemDetail validationException(ValidationException exception) {
        final ProblemDetail pb = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        pb.setTitle("Aconteceu um erro na validação do cupom.");
        pb.setDetail(exception.getMessage());

        return pb;
    }
}
