package com.learn.spring.section8.repositories;

import com.learn.spring.section8.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
}
