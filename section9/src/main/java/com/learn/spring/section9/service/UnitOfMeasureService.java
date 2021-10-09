package com.learn.spring.section9.service;

import com.learn.spring.section9.domain.UnitOfMeasure;
import com.learn.spring.section9.repositories.UnitOfMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        if(uomOptional.isEmpty()){
            throw new RuntimeException("Expected UOM not found");
        }
        return uomOptional.get();
    }
}
