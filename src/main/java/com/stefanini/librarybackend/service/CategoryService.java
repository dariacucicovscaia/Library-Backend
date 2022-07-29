package com.stefanini.librarybackend.service;

import com.stefanini.librarybackend.domain.Category;

import java.util.List;

public interface CategoryService {

    void addCategory(Category category);

    void deleteCategory(int id);

    List<Category> getAllCategories();
}
