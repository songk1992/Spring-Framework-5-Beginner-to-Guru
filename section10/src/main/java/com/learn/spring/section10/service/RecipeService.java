package com.learn.spring.section10.service;

import com.google.common.collect.Lists;
import com.learn.spring.section10.domain.Recipe;
import com.learn.spring.section10.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> saveAll(List<Recipe> list) {
        return Lists.newArrayList(recipeRepository.saveAll(list));
    }

//    public List<Recipe> findAll(){
//        return Lists.newArrayList(recipeRepository.findAll());
//    }

    public Set<Recipe> getRecipes() {
        log.debug("I'm in the service");
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }
}
