package com.openlab.h3_12.domain.port.service;

import com.openlab.h3_12.domain.port.repository.DaoRepository;
import com.openlab.h3_12.infrastructure.entity.DaoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DaoService {
    @Autowired
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
