package com.openlab.h3_12.domain.service;

import com.openlab.h3_12.domain.repository.DaoRepository;
import com.openlab.h3_12.infrastructure.entity.DaoEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DaoService {

    private DaoRepository daoRepository;

    public List<DaoEntity> getAllDaos() {
        return daoRepository.findAll();
    }

    public Optional<DaoEntity> getDaoById(Long id) {
        return daoRepository.findById(id);
    }

    public DaoEntity createDao(DaoEntity dao) {
        return daoRepository.save(dao);
    }

    public void deleteDao(Long id) {
        daoRepository.deleteById(id);
    }
}
