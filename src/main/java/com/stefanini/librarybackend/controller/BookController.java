package com.stefanini.librarybackend.controller;

import com.stefanini.librarybackend.domain.Book;
import com.stefanini.librarybackend.service.BookService;
import com.stefanini.librarybackend.service.impl.BookServiceImpl;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    private Logger logger = Logger.getLogger(BookController.class);
    @Autowired
    private BookService impl;

    public BookController(BookServiceImpl impl) {
        this.impl = impl;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return impl.showAllBooks();
    }

    @PostMapping("/add-new-book")
    public void addNewBook(@RequestBody Book book) {
        impl.addBook(book);
    }

    @PutMapping("/update-book/{id}")
    void updateBook(@PathVariable int id, @RequestBody Book book) {
        Book updatedBook = impl.findById(id);
        updatedBook.setTitle(book.getTitle());
        updatedBook.setDescription(book.getDescription());
        updatedBook.setShelfNumber(book.getShelfNumber());
        updatedBook.setStatus(book.getStatus());
        impl.update(updatedBook);
    }

    @DeleteMapping("/delete-book/{id}")
    public void deleteBook(@PathVariable int id) {
        impl.deleteBook(id);
    }
}