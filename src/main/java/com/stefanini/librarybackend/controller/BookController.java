package com.stefanini.librarybackend.controller;

import com.stefanini.librarybackend.domain.Book;
import com.stefanini.librarybackend.service.BookService;
import com.stefanini.librarybackend.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService impl;

    public BookController(BookServiceImpl impl) {
        this.impl = impl;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return impl.showAllBooks();

    }
@PostMapping("/addNewBook")
    public void addNewBook(@RequestBody Book book){
    impl.addBook(book);
}
}