package com.openlab.h3_12.infrastructure.rest.controller;

import com.openlab.h3_12.application.service.UserService;
import com.openlab.h3_12.domain.dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "User", description = "Endpoints for user management")
public class UserController {
    private final UserService userService;

    @Operation(summary = "Register user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User registered successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
    })
    @PostMapping
    public ResponseEntity<UserDTO> registerUser(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return null;
    }

    @Operation(summary = "Get user by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "403", description = "Forbidden user is not allowed to access this resource"),
    })
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@Parameter(description = "User id", required = true) @PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
        String userIdFromToken = jwt.getClaim("sub");
        if (userIdFromToken.equals(id)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        Optional<UserDTO> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
