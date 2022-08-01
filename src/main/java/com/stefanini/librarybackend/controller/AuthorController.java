package com.stefanini.librarybackend.controller;

import com.stefanini.librarybackend.domain.Author;
import com.stefanini.librarybackend.service.AuthorService;
import com.stefanini.librarybackend.service.impl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    public AuthorController(AuthorServiceImpl authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/addAuthor")
    public Author addAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }

    @PutMapping("/updateAuthor/{id}")
    public Author updateAuthor(@PathVariable int id, @RequestBody Author author) {
        return authorService.update(id, author);
    }

    @PutMapping("/addBookToAuthor/{bookId}/{authorId}")
    public Author addBookToAuthor(@PathVariable int bookId, @PathVariable int authorId) {

    }

    @DeleteMapping("/deleteAuthor/{id}")
    public int deleteAuthor(@PathVariable int id) {
        return authorService.deleteAuthor(id);
    }

    @GetMapping("/getAllAuthors")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }
}
