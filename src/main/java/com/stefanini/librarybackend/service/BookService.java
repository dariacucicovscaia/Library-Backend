package com.stefanini.librarybackend.service;

import com.stefanini.librarybackend.dao.BookDAO;
import com.stefanini.librarybackend.domain.Book;

import java.util.List;

public interface BookService {
    public void addBook(String bookTitle, String bookDescription, String shelfNumber);
    public List<Book> showAllBooks();
}
