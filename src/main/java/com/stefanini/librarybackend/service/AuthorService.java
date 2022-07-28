package com.stefanini.librarybackend.service;

import com.stefanini.librarybackend.domain.Author;

import java.util.List;

/**
 * @author dcuciuc
 */
public interface AuthorService {

    void addAuthor(Author author);

    void update(Author author);

    void deleteAuthor(int id);

    List<Author> getAllAuthors();

}
