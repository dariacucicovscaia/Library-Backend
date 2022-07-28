package com.stefanini.librarybackend.dao;

import com.stefanini.librarybackend.domain.Book;

public interface BookDAO<Book> extends IGenericDao<Book> {
    void updateStatusBook(String bookTitle, String bookStatus, String userId);

    void updateStatusHandAut(String bookTitle, String bookStatus, String userId);

    void updateStatusReturn(String bookTitle);

}
