package com.openlab.h3_12.domain.repository;

import com.openlab.h3_12.infrastructure.entity.DaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DaoRepository extends JpaRepository<DaoEntity,Long> {
    List<DaoEntity> findByName(String name);
}
