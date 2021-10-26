package com.learn.spring.section11.service;

import com.learn.spring.section11.commands.UnitOfMeasureCommand;
import com.learn.spring.section11.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.learn.spring.section11.domain.UnitOfMeasure;
import com.learn.spring.section11.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService{

    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository, UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
    }

    public UnitOfMeasure findByDescription(String uomDescriptionStr) {
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription(uomDescriptionStr);
        if (uomOptional.isEmpty()) {
            throw new RuntimeException("Expected UOM not found");
        }
        return uomOptional.get();
    }

    @Override
    public Set<UnitOfMeasureCommand> listAllUoms() {
        return StreamSupport.stream(unitOfMeasureRepository.findAll().spliterator(),false).map(unitOfMeasureToUnitOfMeasureCommand::convert).collect(Collectors.toSet());
    }
}
