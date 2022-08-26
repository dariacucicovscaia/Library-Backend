package com.stefanini.librarybackend.dao;
import java.util.List;

import java.util.List;

public interface BookDAO<Book> extends IGenericDao<Book> {
    List<Book> getBooksByAnyCriteria (String criteria);


}
