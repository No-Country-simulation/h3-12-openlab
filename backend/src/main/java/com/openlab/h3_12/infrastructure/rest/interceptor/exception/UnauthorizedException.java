package com.openlab.h3_12.infrastructure.rest.interceptor.exception;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }
}
