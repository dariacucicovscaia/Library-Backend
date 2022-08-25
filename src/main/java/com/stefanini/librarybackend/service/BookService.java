package com.stefanini.librarybackend.service;

import com.stefanini.librarybackend.dao.BookDAO;
import com.stefanini.librarybackend.domain.Book;

import java.util.List;

public interface BookService {
    Book addBook(Book book);
    List<Book> showAllBooks();
    Book update(int id, Book book);
    Book findById(int id);
    int deleteBook(int id);
    List<Book> getBookByCategory(int categoryId);
}
