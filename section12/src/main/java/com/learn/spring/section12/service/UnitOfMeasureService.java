package com.learn.spring.section12.service;

import com.learn.spring.section12.commands.UnitOfMeasureCommand;
import com.learn.spring.section12.domain.UnitOfMeasure;

import java.util.Set;

public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();

    UnitOfMeasure findByDescription(String each);

}
