package com.stefanini.librarybackend.dao.impl;

import com.stefanini.librarybackend.dao.BookDAO;
import com.stefanini.librarybackend.dao.impl.DAOAbstractImpl;
import com.stefanini.librarybackend.domain.Book;
import com.stefanini.librarybackend.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookDAOImpl extends DAOAbstractImpl<Book> implements BookDAO<Book> {
    public BookDAOImpl(){
            setClazz(Book.class);
        }


    @Override
    public void updateStatusToBooked(String bookTitle, String bookStatus, String userId) {

    }

    @Override
    public void updateStatusToTaken(String bookTitle, String bookStatus, String userId) {
    }

    @Override
    public void updateStatusWhenReturned(String bookTitle) {

    }




}
