package com.openlab.h3_12.infrastructure.rest.controller;

import com.openlab.h3_12.domain.service.InitiativeService;
import com.openlab.h3_12.infrastructure.entity.InitiativeEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/initiatives")
public class InitiativeController {
    private InitiativeService initiativeService;

    /*
      Obtener todas las iniciativas
      Obtener iniciativa por ID
      Crear una nueva iniciativa
      Actualizar una iniciativa existente
      Eliminar una iniciativa
     */

    @GetMapping
    public ResponseEntity<List<InitiativeEntity>> getAllInitiatives() {
        List<InitiativeEntity> initiatives = initiativeService.getAllInitiatives();
        return ResponseEntity.ok(initiatives);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InitiativeEntity> getInitiativeById(@PathVariable int id) {
        Optional<InitiativeEntity> initiative = initiativeService.getInitiativeById(id);
        return initiative.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<InitiativeEntity> createInitiative(@RequestBody InitiativeEntity initiative) {
        InitiativeEntity createdInitiative = initiativeService.createInitiative(initiative);
        return ResponseEntity.ok(createdInitiative);
    }
    @PutMapping("/{id}")
    public ResponseEntity<InitiativeEntity> updateInitiative(@PathVariable int id, @RequestBody InitiativeEntity initiative) {
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
    public ResponseEntity<Void> deleteInitiative(@PathVariable int id) {
        Optional<InitiativeEntity> existingInitiative = initiativeService.getInitiativeById(id);
        if (existingInitiative.isPresent()) {
            initiativeService.deleteInitiative(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
