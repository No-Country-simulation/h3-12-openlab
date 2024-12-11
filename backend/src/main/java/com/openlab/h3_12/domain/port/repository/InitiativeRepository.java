package com.openlab.h3_12.domain.port.repository;

import com.openlab.h3_12.infrastructure.entity.InitiativeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface InitiativeRepository extends JpaRepository <InitiativeEntity,Long> {

    List<InitiativeEntity> findByName(String name);

    List<InitiativeEntity> findByCreatedAtAfter(LocalDateTime date);
    //Buscar iniciativas por Dao
    List<InitiativeEntity> findByDao_Id(Long daoId);
}
