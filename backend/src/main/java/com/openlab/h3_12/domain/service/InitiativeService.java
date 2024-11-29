package com.openlab.h3_12.domain.service;

import com.openlab.h3_12.domain.repository.InitiativeRepository;
import com.openlab.h3_12.infrastructure.entity.InitiativeEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class InitiativeService {
    private InitiativeRepository initiativeRepository;

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
    public Optional<InitiativeEntity> getInitiativeById(int id) {
        return initiativeRepository.findById((long) id);
    }
    public List<InitiativeEntity> getInitiativesByDao(Long daoId) {
        return initiativeRepository.findByDao_Id(daoId);
    }

    public InitiativeEntity createInitiative(InitiativeEntity initiative) {
        initiative.setCreatedAt(LocalDateTime.now());
        return initiativeRepository.save(initiative);
    }

    public void deleteInitiative(int id) {
        initiativeRepository.deleteById((long) id);
    }
}
