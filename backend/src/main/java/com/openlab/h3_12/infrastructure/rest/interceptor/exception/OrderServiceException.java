package com.openlab.h3_12.infrastructure.rest.interceptor.exception;

public class OrderServiceException extends RuntimeException {
    public OrderServiceException(String errorCreatingOrder, Exception e) {
        super(errorCreatingOrder, e);
    }
}
