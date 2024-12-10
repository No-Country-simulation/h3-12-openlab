package com.openlab.h3_12.domain.port.service;

import com.openlab.h3_12.domain.dto.response.InitiativeResponseDTO;
import com.openlab.h3_12.domain.port.repository.InitiativeRepository;
import com.openlab.h3_12.infrastructure.entity.InitiativeEntity;
import com.openlab.h3_12.infrastructure.rest.interceptor.exception.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.net.http.HttpClient;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class InitiativeService {
    @Autowired
    private InitiativeRepository initiativeRepository;
    
    private HttpClient httpClient;
    private ObjectMapper objectMapper;

    //todaslas iniciativas
    //obtener iniciativa por id
    //obtener por daoId
    //crear iniciativa aumento de fecha ahora
    //borrar por id
    public InitiativeService(InitiativeRepository initiativeRepository) {
        this.initiativeRepository = initiativeRepository;
    }

    public List<InitiativeEntity> getAllInitiatives() {
        return initiativeRepository.findAll();
    }
    public Optional<InitiativeEntity> getInitiativeById(Long id) {
        return initiativeRepository.findById( id);
    }
    public List<InitiativeEntity> getInitiativesByDao(Long daoId) {
        return initiativeRepository.findByDao_Id(daoId);
    }

    public InitiativeEntity createInitiative(InitiativeEntity initiative) {
        initiative.setCreatedAt(LocalDateTime.now());
        return initiativeRepository.save(initiative);
    }

    public void deleteInitiative(Long id) {
        initiativeRepository.deleteById((long) id);
    }

    public List<InitiativeResponseDTO> fetchInitiativesFromApi(String authToken, int offset, int limit) throws Exception {
        String url = String.format("https://apitest.openlab.mx/v1/initiatives?offset=%d&limit=%d", offset, limit);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization", "Bearer " + authToken) // Añadir el token de autorización
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 401) {
            throw new UnauthorizedException("Token de autorización inválido");
        } else if (response.statusCode() != 200) {
            throw new RuntimeException("Error al obtener datos de la API: " + response.body());
        }

        // Procesar la respuesta JSON y convertirla en una lista de DTOs
        return objectMapper.readValue(response.body(), new TypeReference<List<InitiativeResponseDTO>>() {});
    }

}
