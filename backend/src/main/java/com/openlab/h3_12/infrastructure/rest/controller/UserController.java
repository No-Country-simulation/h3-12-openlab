package com.openlab.h3_12.infrastructure.rest.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping()
    public String hello(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return "Hello";
    }

}
