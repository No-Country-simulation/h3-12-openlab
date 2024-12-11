package com.openlab.h3_12.infrastructure.rest.interceptor.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;

public class ErrorResponse implements org.springframework.web.ErrorResponse {
    private final HttpStatusCode statusCode;
    private final ProblemDetail body;
    private final HttpHeaders headers;

    public ErrorResponse(HttpStatusCode statusCode, ProblemDetail body, HttpHeaders headers) {
        this.statusCode = statusCode;
        this.body = body;
        this.headers = headers;
    }

    @Override
    public HttpStatusCode getStatusCode() {
        return statusCode;
    }

    @Override
    public ProblemDetail getBody() {
        return body;
    }

    @Override
    public HttpHeaders getHeaders() {
        return headers;
    }
}
