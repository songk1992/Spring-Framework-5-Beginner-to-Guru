package com.learn.spring.section10.service;

import com.learn.spring.section10.domain.UnitOfMeasure;
import com.learn.spring.section10.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UnitOfMeasureService {

    final UnitOfMeasureRepository unitOfMeasureRepository;

    public UnitOfMeasureService(UnitOfMeasureRepository unitOfMeasureRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    public UnitOfMeasure findByDescription(String uomDescriptionStr) {
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription(uomDescriptionStr);
        if (uomOptional.isEmpty()) {
            throw new RuntimeException("Expected UOM not found");
        }
        return uomOptional.get();
    }
}
