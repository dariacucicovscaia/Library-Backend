package com.stefanini.librarybackend.service;

import com.stefanini.librarybackend.domain.Author;

import java.util.List;

/**
 * This interface is for managing Author entity in database.
 * AuthorService can execute operations with Author entity such as creating, updating, deleting and others.
 *
 * @author dcuciuc
 * @version 0.1
 * @since 0.1
 */
public interface AuthorService {

    /**
     * Create new author.
     *
     * @param author that should be created in controller before calling this method
     * @return the author that was saved in database
     */
    Author addAuthor(Author author);


    /**
     * Perform an updating/editing operation about author and saving it.
     *
     * @param id     of author to be updated/edited
     * @param author object with new data that should be saved
     * @return the author with updated data
     */
    Author update(int id, Author author);


    /**
     * Delete author by id.
     *
     * @param id of author to be deleted
     * @return id of author that was deleted
     */
    int deleteAuthor(int id);


    /**
     * Gets from database all authors.
     *
     * @return list of all authors from database
     */
    List<Author> getAllAuthors();


    /**
     * This method assigns the book to the author using the id of both entities.
     * Then they will be saved in database.
     *
     * @param bookId that need to assign
     * @param id     of author which need to assign a book
     * @return author with assigned book
     */
    Author addBookToAuthor(int bookId, int id);

}
