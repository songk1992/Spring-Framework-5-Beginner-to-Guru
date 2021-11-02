package com.learn.spring.section12.repositories;

import com.learn.spring.section12.domain.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
