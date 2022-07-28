package com.stefanini.librarybackend.service.impl;

import com.stefanini.librarybackend.dao.AuthorDAO;
import com.stefanini.librarybackend.dao.impl.AuthorDAOImpl;
import com.stefanini.librarybackend.domain.Author;
import com.stefanini.librarybackend.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDAO<Author> authorDAO;

    public AuthorServiceImpl(AuthorDAOImpl authorDAOImpl) {

        this.authorDAO = authorDAOImpl;
    }

    @Override
    public void addAuthor(Author author) {
        authorDAO.create(author);
    }

    @Override
    public void update(Author author) {
        authorDAO.update(author);
    }

    @Override
    public void deleteAuthor(int id) {
        authorDAO.remove(id);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorDAO.getAll();
    }
}
