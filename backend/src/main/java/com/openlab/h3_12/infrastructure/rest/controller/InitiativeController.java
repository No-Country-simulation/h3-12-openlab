package com.openlab.h3_12.infrastructure.rest.controller;

import com.openlab.h3_12.domain.dto.request.*;
import com.openlab.h3_12.domain.dto.response.InitiativeResponseDTO;
import com.openlab.h3_12.domain.port.service.InitiativeService;
import com.openlab.h3_12.infrastructure.entity.InitiativeEntity;

import com.openlab.h3_12.infrastructure.rest.interceptor.exception.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/initiatives")
public class InitiativeController {
    @Autowired
    private InitiativeService initiativeService;


    /*
      Obtener todas las iniciativas
      Obtener iniciativa por ID - modificado a /{offset}/{limit}
      Crear una nueva iniciativa - modificado a la de la api
      Actualizar una iniciativa existente
      Eliminar una iniciativa
     */

    @GetMapping("/getInitiatives/{offset}/{limit}")
    public ResponseEntity<?> getInitiatives(
            @PathVariable int offset,
            @PathVariable int limit,
            @RequestHeader("Authorization") String authToken){
        try {
            List<InitiativeResponseDTO> initiatives = initiativeService.fetchInitiativesFromApi(authToken, offset, limit);
            return ResponseEntity.ok(initiatives);
        } catch (UnauthorizedException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token de autorización inválido");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener iniciativas: " + e.getMessage());
        }
    }


    @GetMapping
    public ResponseEntity<List<InitiativeEntity>> getAllInitiatives() {
        List<InitiativeEntity> initiatives = initiativeService.getAllInitiatives();
        return ResponseEntity.ok(initiatives);
    }
/*
    @GetMapping("/{id}")
    public ResponseEntity<InitiativeEntity> getInitiativeById(@PathVariable int id) {
        Optional<InitiativeEntity> initiative = initiativeService.getInitiativeById(id);
        return initiative.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }*/
    /*
    @PostMapping
    public ResponseEntity<InitiativeEntity> createInitiative(@RequestBody InitiativeEntity initiative) {
        InitiativeEntity createdInitiative = initiativeService.createInitiative(initiative);
        return ResponseEntity.ok(createdInitiative);
    }*/
    @PostMapping("/createInitiative")
    public String createInitiative(@RequestBody InitiativeRequestDTO initiative,
                                   @RequestHeader("Authorization") String authToken) {

        HttpClient client = HttpClient.newHttpClient();

        String jsonBody = String.format(
                "{\"name\":\"%s\",\"idea\":\"%s\",\"problem\":\"%s\",\"opportunity\":\"%s\",\"solution\":\"%s\",\"wallet_address\":\"%s\",\"logo\":\"%s\"}",
                initiative.getName(),
                initiative.getIdea(),
                initiative.getProblem(),
                initiative.getOpportunity(),
                initiative.getSolution(),
                initiative.getWalletAddress(),
                initiative.getLogo()
        );

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://apitest.openlab.mx/v1/initiative"))
                .header("Authorization", "Bearer " + authToken)  // Usando el token de autorización
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody)) // Enviando el JSON en el cuerpo
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return "Iniciativa creada con éxito: " + response.body();
            } else {
                return "Error al crear la iniciativa: " + response.statusCode() + " " + response.body();
            }

        } catch (Exception e) {
            return "Error en la comunicación con la API: " + e.getMessage();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<InitiativeEntity> updateInitiative(@PathVariable Long id, @RequestBody InitiativeEntity initiative) {
        Optional<InitiativeEntity> existingInitiative = initiativeService.getInitiativeById(id);
        if (existingInitiative.isPresent()) {
            initiative.setId(id);
            InitiativeEntity updatedInitiative = initiativeService.createInitiative(initiative);
            return ResponseEntity.ok(updatedInitiative);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInitiative(@PathVariable Long id) {
        Optional<InitiativeEntity> existingInitiative = initiativeService.getInitiativeById(id);
        if (existingInitiative.isPresent()) {
            initiativeService.deleteInitiative(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
