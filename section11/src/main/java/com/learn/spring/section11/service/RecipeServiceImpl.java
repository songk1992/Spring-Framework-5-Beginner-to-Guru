package com.learn.spring.section11.service;

import com.google.common.collect.Lists;
import com.learn.spring.section11.domain.Recipe;
import com.learn.spring.section11.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> saveAll(List<Recipe> list) {
        return Lists.newArrayList(recipeRepository.saveAll(list));
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("I'm in the service");
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }

    @Override
    public Recipe findById(Long l) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(1L);
        if (recipeOptional.isEmpty()) {
            throw new RuntimeException("Recipe Not Found!");
        }
        return recipeOptional.get();
    }


}
