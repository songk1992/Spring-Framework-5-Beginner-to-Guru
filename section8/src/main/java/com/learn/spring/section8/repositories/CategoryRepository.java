package com.learn.spring.section8.repositories;

import com.learn.spring.section8.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
