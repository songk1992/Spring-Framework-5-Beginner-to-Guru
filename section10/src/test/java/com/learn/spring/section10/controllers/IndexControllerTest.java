package com.learn.spring.section10.controllers;

import com.learn.spring.section10.service.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IndexControllerTest {

    @Mock
    Model model;

    IndexController controller;

    @Mock
    RecipeService recipeService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        controller = new IndexController(recipeService);
    }

    @Test
    @DisplayName("콘트롤러가 뷰를 잘 리턴하는지 테스트")
    public void getIndexPageTest(){
        String viewName = controller.getIndexPage(model);
        assertEquals("index", viewName);
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"),anySet());
    }
}