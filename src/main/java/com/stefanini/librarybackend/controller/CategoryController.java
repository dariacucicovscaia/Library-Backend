package com.stefanini.librarybackend.controller;

import com.stefanini.librarybackend.domain.Category;
import com.stefanini.librarybackend.service.CategoryService;
import com.stefanini.librarybackend.service.impl.CategoryServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority('LIBRARIAN', 'ADMIN')")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @PutMapping("/assignBook/{bookId}/{id}")
    @PreAuthorize("hasAnyAuthority('LIBRARIAN', 'ADMIN')")
    public Category addBookToCategory(@PathVariable int bookId, @PathVariable int id) {
        return categoryService.addBookToCategory(bookId, id);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('LIBRARIAN', 'ADMIN')")
    public int deleteCategory(@PathVariable int id) {
        return categoryService.deleteCategory(id);
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
}
