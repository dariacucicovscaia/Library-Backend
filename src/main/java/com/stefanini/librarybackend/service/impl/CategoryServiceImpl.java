package com.stefanini.librarybackend.service.impl;

import com.stefanini.librarybackend.dao.CategoryDAO;
import com.stefanini.librarybackend.dao.impl.CategoryDAOImpl;
import com.stefanini.librarybackend.domain.Category;
import com.stefanini.librarybackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDAO<Category> categoryDAO;

    public CategoryServiceImpl(CategoryDAOImpl categoryDAOImpl) {
        this.categoryDAO = categoryDAOImpl;
    }

    @Override
    public void addCategory(Category category) {
        categoryDAO.create(category);
    }

    @Override
    public void deleteCategory(int id) {
        categoryDAO.remove(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryDAO.getAll();
    }
}
