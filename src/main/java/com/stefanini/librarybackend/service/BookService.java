package com.stefanini.librarybackend.service;

import com.stefanini.librarybackend.domain.Book;
import com.stefanini.librarybackend.domain.History;

import java.util.List;

public interface BookService {
    Book addBook(Book book);
    List<Book> showAllBooks();
    Book update(int id, Book book);
    Book findById(int id);
    int deleteBook(int id);
    Book bookTheBook (int bookId, int userId);
    Book giveTheBook (int bookId, int userId);
    Book returnTheBook (int bookId);
    List<Book> findBooksByAnyCriteria(String criteria);

    List<Book> getBookByCategory(int categoryId);

    List<Book> findBooksByAuthor(int authorId);
}
