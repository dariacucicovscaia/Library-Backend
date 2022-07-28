package com.stefanini.librarybackend.service.impl;

import com.stefanini.librarybackend.dao.BookDAO;
import com.stefanini.librarybackend.dao.impl.BookDAOImpl;
import com.stefanini.librarybackend.domain.Book;
import com.stefanini.librarybackend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service

public class BookServiceImpl implements BookService {
@Autowired
    private BookDAO<Book> bookDAOImpl ;


    public BookServiceImpl(BookDAOImpl bookDAOImpl) {

        this.bookDAOImpl=bookDAOImpl;
    }

@Transactional
    @Override
    public void addBook(Book book) {
        bookDAOImpl.create(book);
    }

@Transactional
    @Override
    public List<Book> showAllBooks() {
       return bookDAOImpl.getAll();
    }
}
