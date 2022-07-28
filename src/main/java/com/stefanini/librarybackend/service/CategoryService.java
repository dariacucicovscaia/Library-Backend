package com.stefanini.librarybackend.service;

import com.stefanini.librarybackend.domain.Category;

public interface CategoryService {

    void addCategory(Category category);

    void deleteCategory(int id);
}
