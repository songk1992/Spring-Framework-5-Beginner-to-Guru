package com.learn.spring.section8.service;

import com.learn.spring.section8.domain.Recipe;
import com.learn.spring.section8.repositories.RecipeRepository;
import org.springframework.stereotype.Service;
import com.google.common.collect.Lists;

import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> saveAll(List<Recipe> list) {
        return Lists.newArrayList(recipeRepository.saveAll(list));
    }
}
