package com.learn.spring.section8.repositories;

import com.learn.spring.section8.domain.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
