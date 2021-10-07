package com.learn.spring.section8.controllers;

import com.learn.spring.section8.domain.Category;
import com.learn.spring.section8.domain.UnitOfMeasure;
import com.learn.spring.section8.repositories.CategoryRepository;
import com.learn.spring.section8.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){

        Optional<Category> categoryOptional = categoryRepository.findByDescription("Korean");
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription("Teaspoon");

        categoryOptional.ifPresent(category -> System.out.println("Ctg Id is : " + category.getId()));
        unitOfMeasure.ifPresent(ofMeasure -> System.out.println("uom Id is : " + ofMeasure.getId()));

        return "index";
    }
}
