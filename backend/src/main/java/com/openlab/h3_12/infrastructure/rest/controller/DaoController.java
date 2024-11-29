package com.openlab.h3_12.infrastructure.rest.controller;

import com.openlab.h3_12.domain.service.DaoService;
import com.openlab.h3_12.infrastructure.entity.DaoEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/daos")
public class DaoController {
    private DaoService daoService;

    /*
    tener todas las DAOs
    tener DAO por ID
    Crear una nueva DAO
    Actualizar una DAO existente -> todos los datos
    Eliminar una DAO
     */

    @GetMapping
    public ResponseEntity<List<DaoEntity>> getAllDaos() {
        List<DaoEntity> daos = daoService.getAllDaos();
        return ResponseEntity.ok(daos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DaoEntity> getDaoById(@PathVariable Long id) {
        Optional<DaoEntity> dao = daoService.getDaoById(id);
        return dao.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DaoEntity> createDao(@RequestBody DaoEntity dao) {
        DaoEntity createdDao = daoService.createDao(dao);
        return ResponseEntity.ok(createdDao);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DaoEntity> updateDao(@PathVariable Long id, @RequestBody DaoEntity dao) {
        Optional<DaoEntity> existingDao = daoService.getDaoById(id);
        if (existingDao.isPresent()) {
            dao.setId(id);
            DaoEntity updatedDao = daoService.createDao(dao);
            return ResponseEntity.ok(updatedDao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDao(@PathVariable Long id) {
        Optional<DaoEntity> existingDao = daoService.getDaoById(id);
        if (existingDao.isPresent()) {
            daoService.deleteDao(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
