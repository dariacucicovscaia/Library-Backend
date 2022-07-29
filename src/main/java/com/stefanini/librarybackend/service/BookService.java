package com.stefanini.librarybackend.service;

import com.stefanini.librarybackend.dao.BookDAO;
import com.stefanini.librarybackend.domain.Book;

import java.util.List;

public interface BookService {
    void addBook(Book book);
    List<Book> showAllBooks();
    void update(Book book);
    Book findById(int id);
    void deleteBook(int id);
}
