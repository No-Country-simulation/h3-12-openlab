package com.openlab.h3_12.infrastructure.rest.interceptor.exception;

import lombok.Data;

import java.util.List;

@Data
public class ErrorValidationResponse {
    private List<ValidationError> errors;

    public ErrorValidationResponse(List<ValidationError> errors) {
        this.errors = errors;
    }
}

