package com.stefanini.librarybackend.service.impl;

import com.stefanini.librarybackend.dao.CategoryDAO;
import com.stefanini.librarybackend.dao.impl.CategoryDAOImpl;
import com.stefanini.librarybackend.domain.Category;
import com.stefanini.librarybackend.service.CategoryService;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryDAO<Category> categoryDAO;

    public CategoryServiceImpl(CategoryDAOImpl categoryDAOImpl) {
        this.categoryDAO = categoryDAOImpl;
    }

    @Override
    public Category addCategory(Category category) {
        return categoryDAO.create(category);
    }

    @Override
    public int deleteCategory(int id) {
        return categoryDAO.removeById(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryDAO.getAll();
    }
}
