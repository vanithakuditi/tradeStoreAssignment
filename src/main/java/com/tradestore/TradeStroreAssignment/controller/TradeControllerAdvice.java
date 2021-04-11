package com.tradestore.TradeStroreAssignment.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tradestore.TradeStroreAssignment.exceptions.InvalidTradeException;

@ControllerAdvice
@RequestMapping
public class TradeControllerAdvice {
	@ExceptionHandler(InvalidTradeException.class)
    public ResponseEntity<String> notFoundException(final InvalidTradeException e) {
        return error(e, HttpStatus.NOT_ACCEPTABLE, e.getId());
    }

    private ResponseEntity<String> error(
            final Exception exception, final HttpStatus httpStatus, final String logRef) {
        final String message =
                Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
        return new ResponseEntity<>(message, httpStatus);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> assertionException(final IllegalArgumentException e) {
        return error(e, HttpStatus.NOT_ACCEPTABLE, e.getLocalizedMessage());
    }
}
