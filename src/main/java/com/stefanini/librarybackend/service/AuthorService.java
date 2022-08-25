package com.stefanini.librarybackend.service;

import com.stefanini.librarybackend.domain.Author;
import com.stefanini.librarybackend.domain.Book;

import java.util.List;

/**
 * @author dcuciuc
 */
public interface AuthorService {

    Author addAuthor(Author author);

    Author update(int id, Author author);

    int deleteAuthor(int id);

    List<Author> getAllAuthors();

    Author findById(int id);

    Author addBookToAuthor(int bookId, int id);

    List<Book> findBooksByAuthor(int authorId);
}
