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

    private final BookService bookService;

    public BookController(BookServiceImpl bookServiceImpl) {
        this.bookService = bookServiceImpl;
    }

    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority('LIBRARIAN', 'ADMIN')")
    public Book createBook(@RequestBody Book book) {
       return bookService.addBook(book);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAnyAuthority('LIBRARIAN', 'ADMIN')")
    public Book updateBook(@PathVariable int id, @RequestBody Book book) {
        return bookService.update(id, book);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('LIBRARIAN', 'ADMIN')")
    public void deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
    }
        
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.showAllBooks();
    }

    @GetMapping("/bookByCategory/{categoryId}")
    @PreAuthorize("hasAnyAuthority('LIBRARIAN', 'ADMIN')")
    public List<Book> getBooksByCategory(@PathVariable int categoryId){
        return bookService.getBookByCategory(categoryId);
    }
}