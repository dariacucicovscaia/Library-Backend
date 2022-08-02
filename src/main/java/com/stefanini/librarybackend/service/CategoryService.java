package com.stefanini.librarybackend.service;

import com.stefanini.librarybackend.domain.Category;

import java.util.List;

public interface CategoryService {

    Category addCategory(Category category);

    int deleteCategory(int id);

    List<Category> getAllCategories();

    Category addBookToCategory(int bookId, int id);
}
