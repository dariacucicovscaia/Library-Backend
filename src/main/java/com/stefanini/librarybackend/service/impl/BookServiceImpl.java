package com.stefanini.librarybackend.service.impl;

import com.stefanini.librarybackend.dao.BookDAO;
import com.stefanini.librarybackend.dao.impl.BookDAOImpl;
import com.stefanini.librarybackend.domain.Book;
import com.stefanini.librarybackend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service

public class BookServiceImpl implements BookService {
    @Autowired
    private final BookDAO<Book> bookDAOImpl;



    public BookServiceImpl(BookDAOImpl bookDAOImpl) {
        this.bookDAOImpl = bookDAOImpl;
    }


    @Override
    public Book addBook(Book book) {
        return bookDAOImpl.create(book);
    }

    @Override
    public List<Book> showAllBooks() {
        return bookDAOImpl.getAll();
    }

    @Override
    public Book update(int id, Book book) {
        Book updatedBook = bookDAOImpl.getById(id);
        updatedBook.setTitle(book.getTitle());
        updatedBook.setDescription(book.getDescription());
        updatedBook.setShelfNumber(book.getShelfNumber());
        updatedBook.setStatus(book.getStatus());
        return bookDAOImpl.update(updatedBook);
    }


    @Override
    public Book findById(int id) {
        return bookDAOImpl.getById(id);
    }


    @Override
    public int deleteBook(int id) {
        return bookDAOImpl.removeById(id);

    }
}
