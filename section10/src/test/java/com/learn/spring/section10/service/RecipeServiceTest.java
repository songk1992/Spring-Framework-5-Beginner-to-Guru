package com.learn.spring.section10.service;

import com.learn.spring.section10.domain.Recipe;
import com.learn.spring.section10.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeServiceTest {

    RecipeService recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeService(recipeRepository);
    }

    @Test
    public void getRecipes() {
        Recipe recipe = new Recipe();
        HashSet<Recipe> receipesData = new HashSet<>();
        receipesData.add(recipe);

        when(recipeService.getRecipes()).thenReturn(receipesData);
        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(recipes.size(), 1);
        verify(recipeRepository, times(1)).findAll();
    }
}