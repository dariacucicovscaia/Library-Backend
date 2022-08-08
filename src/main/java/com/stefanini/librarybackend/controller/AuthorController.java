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
    public void addAuthor(@RequestBody Author author) {
        authorService.addAuthor(author);
    }

    @PutMapping("/updateAuthor/{id}")
    public void updateAuthor(@PathVariable int id, @RequestBody Author author) {
        Author updatedAuthor = authorService.findById(id);
        updatedAuthor.setFirstName(author.getFirstName());
        updatedAuthor.setLastName(author.getLastName());
        updatedAuthor.setBirthDate(author.getBirthDate());
        updatedAuthor.setBiography(author.getBiography());
        authorService.update(updatedAuthor);
    }

    @DeleteMapping("/deleteAuthor/{id}")
    public void deleteAuthor(@PathVariable int id) {
        authorService.deleteAuthor(id);
    }

    @GetMapping("/getAllAuthors")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }
}
