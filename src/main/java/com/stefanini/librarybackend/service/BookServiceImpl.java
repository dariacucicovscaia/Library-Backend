package com.stefanini.librarybackend.service;

import com.stefanini.librarybackend.dao.BookDAO;
import com.stefanini.librarybackend.dao.BookDAOImpl;
import com.stefanini.librarybackend.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.PersistenceContext;
import java.util.List;
@Service

public class BookServiceImpl implements BookService{
@Autowired
    private BookDAO<Book> bookDAOImpl ;


    public BookServiceImpl(BookDAOImpl bookDAOImpl) {

        this.bookDAOImpl=bookDAOImpl;
    }

@Transactional
    @Override
    public void addBook(String bookTitle, String bookDescription, String shelfNumber) {
        bookDAOImpl.create(new Book(bookTitle, bookDescription, shelfNumber));
    }

@Transactional
    @Override
    public List<Book> showAllBooks() {
       return bookDAOImpl.getAll();
    }
}
