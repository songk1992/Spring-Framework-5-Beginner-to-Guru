package com.learn.spring.section12.repositories;

import com.learn.spring.section12.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByDescription(String description);

    @Override
    <S extends UnitOfMeasure> S save(S entity);

    @Override
    <S extends UnitOfMeasure> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    Optional<UnitOfMeasure> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    Iterable<UnitOfMeasure> findAll();

    @Override
    Iterable<UnitOfMeasure> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(UnitOfMeasure entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends UnitOfMeasure> entities);

    @Override
    void deleteAll();
}
