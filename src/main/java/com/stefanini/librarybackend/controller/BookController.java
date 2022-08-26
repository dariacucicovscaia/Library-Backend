package com.stefanini.librarybackend.controller;

import com.stefanini.librarybackend.domain.Book;
import com.stefanini.librarybackend.service.AuthorService;
import com.stefanini.librarybackend.service.BookService;
import com.stefanini.librarybackend.service.impl.BookServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookServiceImpl bookServiceImpl, AuthorService authorService) {
        this.bookService = bookServiceImpl;
        this.authorService = authorService;
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
    @PutMapping("/bookTheBook/{bookId}/{userId}")
   @PreAuthorize("hasAnyAuthority('USER','LIBRARIAN', 'ADMIN')")
    public Book bookTheBook (@PathVariable int bookId, @PathVariable int userId) {
        return bookService.bookTheBook(bookId, userId);
    }
    @PutMapping("/giveTheBook/{bookId}/{userId}")
    @PreAuthorize("hasAnyAuthority('LIBRARIAN', 'ADMIN')")
    public Book giveTheBook (@PathVariable int bookId, @PathVariable int userId) {
        return bookService.giveTheBook(bookId, userId);
    }
    @PutMapping("/returnTheBook/{bookId}")
    @PreAuthorize("hasAnyAuthority('LIBRARIAN', 'ADMIN')")
    public Book returnTheBook (@PathVariable int bookId) {
        return bookService.returnTheBook(bookId);
    }

    @GetMapping("/find_books_by_criteria/{criteria}")
    public List<Book> findBooksByCriteria(@PathVariable String criteria) {
        return bookService.findBooksByAnyCriteria(criteria);
    }
    @GetMapping("/bookByAuthor/{authorId}")
    public List<Book> findBooksByAuthorId(@PathVariable int authorId) {
        return authorService.findBooksByAuthor(authorId);
    }

    @GetMapping("/bookByCategory/{categoryId}")
    public List<Book> getBooksByCategory(@PathVariable int categoryId){
        return bookService.getBookByCategory(categoryId);
    }
}