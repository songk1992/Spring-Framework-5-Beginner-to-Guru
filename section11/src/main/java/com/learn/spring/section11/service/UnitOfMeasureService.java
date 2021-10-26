package com.learn.spring.section11.service;

import com.learn.spring.section11.commands.UnitOfMeasureCommand;
import com.learn.spring.section11.domain.UnitOfMeasure;

import java.util.Set;

public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();

    UnitOfMeasure findByDescription(String each);

}
