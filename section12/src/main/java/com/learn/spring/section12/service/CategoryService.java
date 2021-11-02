package com.learn.spring.section12.service;

import com.learn.spring.section12.domain.Category;
import com.learn.spring.section12.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category findByDescription(String categoryNameStr) {
        Optional<Category> categoryOptionalOptional = categoryRepository.findByDescription(categoryNameStr);
        if (categoryOptionalOptional.isEmpty()) {
            throw new RuntimeException("Expected UOM not found");
        }
        return categoryOptionalOptional.get();
    }

}
