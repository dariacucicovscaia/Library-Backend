package com.stefanini.librarybackend.dao;

import com.stefanini.librarybackend.domain.Book;

import java.util.List;

public interface BookDAO<Book> extends IGenericDao<Book> {
    List<Book> getBooksByAnyCriteria (String criteria);

}
