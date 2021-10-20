package com.learn.spring.section11.service;

import com.learn.spring.section11.commands.RecipeCommand;
import com.learn.spring.section11.domain.Recipe;

import java.util.List;
import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
    Recipe findById(Long l);
    List<Recipe> saveAll(List<Recipe> list);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
