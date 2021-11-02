package com.learn.spring.section12.service;

import com.learn.spring.section12.commands.RecipeCommand;
import com.learn.spring.section12.domain.Recipe;

import java.util.List;
import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
    Recipe findById(Long l);
    List<Recipe> saveAll(List<Recipe> list);

    RecipeCommand findCommandById(Long l);
    RecipeCommand saveRecipeCommand(RecipeCommand command);

    void deleteById(Long idToDelete);
}
