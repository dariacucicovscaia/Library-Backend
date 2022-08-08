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

    private BookService impl;

    public BookController(BookServiceImpl impl) {
        this.impl = impl;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return impl.showAllBooks();
    }

    @PostMapping("/add-new-book")
    public Book addNewBook(@RequestBody Book book) {
        return impl.addBook(book);
    }

    @PutMapping("/update-book/{id}")
    Book updateBook(@PathVariable int id, @RequestBody Book book) {

       return impl.update(id, book);
    }

    @DeleteMapping("/delete-book/{id}")
    public int deleteBook(@PathVariable int id) {
        return impl.deleteBook(id);
    }
}