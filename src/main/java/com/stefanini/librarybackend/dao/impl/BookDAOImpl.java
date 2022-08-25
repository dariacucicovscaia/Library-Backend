package com.stefanini.librarybackend.dao.impl;

import com.stefanini.librarybackend.dao.BookDAO;
import com.stefanini.librarybackend.dao.impl.DAOAbstractImpl;
import com.stefanini.librarybackend.domain.Author;
import com.stefanini.librarybackend.domain.Book;
import com.stefanini.librarybackend.domain.User;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
=======
import javax.persistence.TypedQuery;
import java.util.ArrayList;
>>>>>>> 0eb17c67b02e8eccd12b20ab6f932f0296ce86ae
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

<<<<<<< HEAD
=======
    @Override
    public void updateStatusToTaken(String bookTitle, String bookStatus, String userId) {
    }

    @Override
    public void updateStatusWhenReturned(String bookTitle) {

    }




>>>>>>> 0eb17c67b02e8eccd12b20ab6f932f0296ce86ae
}
