package com.stefanini.librarybackend.dao;

import com.stefanini.librarybackend.domain.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAOImpl extends DAOAbstractImpl<Book> implements BookDAO<Book>{
    public BookDAOImpl(){
            setClazz(Book.class);
        }


    @Override
    public void updateStatusBook(String bookTitle, String bookStatus, String userId) {

    }

    @Override
    public void updateStatusHandAut(String bookTitle, String bookStatus, String userId) {

    }

    @Override
    public void updateStatusReturn(String bookTitle) {

    }
}
