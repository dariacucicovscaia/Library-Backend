package com.stefanini.librarybackend.controller;

import com.stefanini.librarybackend.domain.Book;
import com.stefanini.librarybackend.service.BookService;
import com.stefanini.librarybackend.service.impl.BookServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {
    private final Logger logger = Logger.getLogger(BookController.class);
    @Autowired
    private final BookService impl;

    public BookController(BookServiceImpl impl) {
        this.impl = impl;
    }

    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority('LIBRARIAN', 'ADMIN')")
    public void addNewBook(@RequestBody Book book) {
        impl.addBook(book);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAnyAuthority('LIBRARIAN', 'ADMIN')")
    void updateBook(@PathVariable int id, @RequestBody Book book) {
        Book updatedBook = impl.findById(id);
        updatedBook.setTitle(book.getTitle());
        updatedBook.setDescription(book.getDescription());
        updatedBook.setShelfNumber(book.getShelfNumber());
        updatedBook.setStatus(book.getStatus());
        impl.update(updatedBook);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('LIBRARIAN', 'ADMIN')")
    public void deleteBook(@PathVariable int id) {
        impl.deleteBook(id);
    }

    @GetMapping("/books")
    @PreAuthorize("hasAnyAuthority('USER', 'LIBRARIAN', 'ADMIN')")
    public List<Book> getAllBooks() {
        return impl.showAllBooks();
    }
}