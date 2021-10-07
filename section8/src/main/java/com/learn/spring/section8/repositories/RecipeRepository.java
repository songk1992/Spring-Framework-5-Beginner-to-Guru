package com.learn.spring.section8.repositories;

import com.learn.spring.section8.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
