package com.openlab.h3_12.infrastructure.rest.controller;

import com.openlab.h3_12.domain.dto.OrderDTO;
import com.openlab.h3_12.domain.service.OrderServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Tag(name = "Order" , description = "Endpoints for managing buy and sell orders")
public class OrderController {
    private final OrderServicePort orderService;

    @Operation(summary = "Get orders buy/sell by id")
    @GetMapping("{id}")
    public ResponseEntity<OrderDTO> getOrderById(@Parameter(description = "Order id", required = true) @PathVariable Long id) {
        return orderService.getOrderById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Allows you to create a new order (buy or sell) associated with a DAO.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
    })
    @PostMapping()
    public ResponseEntity<OrderDTO> createOrder(@Parameter(description = "Order", required = true) @Valid @RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok(orderService.createOrder(orderDTO));
    }

    @Operation(summary = "Execute a token purchase using a posted order.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order executed successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
    })
    @PostMapping("{id}/buy")
    public ResponseEntity<OrderDTO> buyOrder(@Parameter(description = "Order id", required = true) @PathVariable String id) {
        return null;
    }

    @Operation(summary = "Execute a token sale through an existing order.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order executed successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
    })
    @PostMapping("{id}/sell")
    public ResponseEntity<OrderDTO> sellOrder(@Parameter(description = "Order id", required = true) @PathVariable String id) {
        return null;
    }

    @Operation(summary = "Cancel an existing order.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order canceled successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
    })
    @DeleteMapping("{id}")
    public ResponseEntity<OrderDTO> cancelOrder(@Parameter(description = "Order id", required = true) @PathVariable String id) {
        return null;
    }


}
