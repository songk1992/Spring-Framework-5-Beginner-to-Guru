package com.learn.spring.section12.controllers;

import com.learn.spring.section12.commands.IngredientCommand;
import com.learn.spring.section12.commands.RecipeCommand;
import com.learn.spring.section12.service.IngredientService;
import com.learn.spring.section12.service.RecipeService;
import com.learn.spring.section12.service.UnitOfMeasureService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class IngredientControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    IngredientService ingredientService;

    @Mock
    UnitOfMeasureService unitOfMeasureService;

    IngredientController controller;

    MockMvc mockMvc;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        controller = new IngredientController(recipeService, ingredientService, unitOfMeasureService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testListIngredients() throws Exception {
        // given
        RecipeCommand recipeCommand = new RecipeCommand();
        when(recipeService.findCommandById(anyLong())).thenReturn(recipeCommand);

        // when
        mockMvc.perform(get("/recipe/1/ingredients"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/ingredient/list"))
                .andExpect(model().attributeExists("recipe"));

        // then
        verify(recipeService, times(1)).findCommandById(anyLong());
    }

    @Test
    public void testShowIngredient() throws Exception {
        // given
        IngredientCommand ingredientCommand = new IngredientCommand();

        // when
        when(ingredientService.findByRecipeIdAndIngredientId(anyLong(), anyLong())).thenReturn(ingredientCommand);

        // then
        mockMvc.perform(get("/recipe/1/ingredient/2/show"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/ingredient/show"))
                .andExpect(model().attributeExists("ingredient"));
    }

    @Test
    public void testNewIngredientForm() throws Exception{
        // given
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(1L);

        // when
        when(recipeService.findCommandById(anyLong())).thenReturn(recipeCommand);
        when(unitOfMeasureService.listAllUoms()).thenReturn(new HashSet<>());

        // then
        mockMvc.perform(get("/recipe/1/ingredient/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/ingredient/ingredientform"))
                .andExpect(model().attributeExists("ingredient"))
                .andExpect(model().attributeExists("uomList"));
        verify(recipeService, times(1)).findCommandById(anyLong());
    }

    @Test
    public void testUpdateIngredientForm() throws Exception{
        // given
        IngredientCommand ingredientCommand = new IngredientCommand();
    }

    @Test
    public void testDeleteIngredient1() throws Exception{
        // then
        mockMvc.perform(get("/recipe/1/ingredient/2/delete")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("id", "")
                .param("description", "some string")
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/recipe/1/ingredients"));

    }

    @Test
    public void testDeleteIngredient2() throws Exception{

        // then
        mockMvc.perform(get("/recipe/1/ingredient/1/delete"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/recipe/1/ingredients"));

        verify(ingredientService, times(1)).deleteById(anyLong(), anyLong());

    }
}
