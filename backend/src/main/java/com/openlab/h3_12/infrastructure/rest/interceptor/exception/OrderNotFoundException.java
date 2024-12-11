package com.openlab.h3_12.infrastructure.rest.interceptor.exception;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String message) {
        super(message);
    }
}
