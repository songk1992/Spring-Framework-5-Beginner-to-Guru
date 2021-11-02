package com.learn.spring.section12.service;

import com.learn.spring.section12.commands.IngredientCommand;
import com.learn.spring.section12.converters.IngredientCommandToIngredient;
import com.learn.spring.section12.converters.IngredientToIngredientCommand;
import com.learn.spring.section12.converters.UnitOfMeasureCommandToUnitOfMeasure;
import com.learn.spring.section12.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.learn.spring.section12.domain.Ingredient;
import com.learn.spring.section12.domain.Recipe;
import com.learn.spring.section12.repositories.RecipeRepository;
import com.learn.spring.section12.repositories.UnitOfMeasureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class IngredientServiceImplTest {

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final IngredientCommandToIngredient ingredientCommandToIngredient;

    @Mock
    RecipeRepository recipeRepository;

    IngredientService ingredientService;

    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;

    public IngredientServiceImplTest() {
        this.ingredientToIngredientCommand = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
        this.ingredientCommandToIngredient = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    }

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ingredientService = new IngredientServiceImpl(ingredientToIngredientCommand, ingredientCommandToIngredient,
                unitOfMeasureRepository, recipeRepository);
    }

    @Test
    public void findByRecipeIdAndId() throws Exception {
    }

    @Test
    public void findByRecipeIdAndIngredientId() throws Exception {
        //given
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(1L);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(1L);

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setId(3L);

        recipe.addIngredient(ingredient1);
        recipe.addIngredient(ingredient2);
        recipe.addIngredient(ingredient3);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        // then
        IngredientCommand ingredientCommand = ingredientService.findByRecipeIdAndIngredientId(1L, 3L);

        // when
        assertEquals(Long.valueOf(3L), ingredientCommand.getId());
        assertEquals(Long.valueOf(1L), ingredientCommand.getRecipeId());
        verify(recipeRepository, times(1)).findById(anyLong());


    }

    @Test
    public void testSaveRecipeCommand() throws Exception {
        //given
        IngredientCommand command = new IngredientCommand();
        command.setId(3L);
        command.setRecipeId(2L);

        Optional<Recipe> recipeOptional = Optional.of(new Recipe());

        Recipe savedRecipe = new Recipe();
        savedRecipe.addIngredient(new Ingredient());
        savedRecipe.getIngredients().iterator().next().setId(3L);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);
        when(recipeRepository.save(any())).thenReturn(savedRecipe);

        //when
        IngredientCommand savedCommand = ingredientService.saveIngredientCommand(command);

        //then
        assertEquals(Long.valueOf(3L), savedCommand.getId());
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, times(1)).save(any(Recipe.class));

    }
}