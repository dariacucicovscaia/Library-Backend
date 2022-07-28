package com.stefanini.librarybackend.controller;

import com.stefanini.librarybackend.domain.Author;
import com.stefanini.librarybackend.service.AuthorService;
import com.stefanini.librarybackend.service.impl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    AuthorService authorService;

    public AuthorController(AuthorServiceImpl authorService) {
        this.authorService = authorService;
    }

    public void addAuthor(String firstName, String lastName, Date birthDate, String biography) {
        authorService.addAuthor(new Author(firstName, lastName, birthDate, biography));
    }

    public void updateAuthor(String firstName, String lastName, Date birthDate, String biography) {
        authorService.update(new Author(firstName, lastName, birthDate, biography));
    }

    public void deleteAuthor(int id) {
        authorService.deleteAuthor(id);
    }

    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }
}
