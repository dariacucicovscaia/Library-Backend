package com.stefanini.librarybackend.controller;

import com.stefanini.librarybackend.domain.Category;
import com.stefanini.librarybackend.service.CategoryService;
import com.stefanini.librarybackend.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    public void addCategory(String title) {
        categoryService.addCategory(new Category(title));
    }

    public void deleteCategory(int id) {
        categoryService.deleteCategory(id);
    }
}
