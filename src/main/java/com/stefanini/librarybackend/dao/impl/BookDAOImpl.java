package com.stefanini.librarybackend.dao.impl;

import com.stefanini.librarybackend.dao.BookDAO;
import com.stefanini.librarybackend.dao.impl.DAOAbstractImpl;
import com.stefanini.librarybackend.domain.Author;
import com.stefanini.librarybackend.domain.Book;
import com.stefanini.librarybackend.domain.User;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class BookDAOImpl extends DAOAbstractImpl<Book> implements BookDAO<Book> {
    public BookDAOImpl(){
            setClazz(Book.class);
        }


    @Override
    public List<Book> getBooksByAnyCriteria(String criteria) {
        return entityManager.createQuery("from Book" +  " WHERE title LIKE '%" + criteria +
                "%' OR bookDescription LIKE '%" + criteria + "%'" ).getResultList();
    }



}
