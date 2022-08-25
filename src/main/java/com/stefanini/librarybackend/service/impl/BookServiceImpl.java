package com.stefanini.librarybackend.service.impl;

import com.stefanini.librarybackend.dao.BookDAO;
import com.stefanini.librarybackend.dao.HistoryDAO;
import com.stefanini.librarybackend.dao.UserDAO;
import com.stefanini.librarybackend.dao.impl.BookDAOImpl;
import com.stefanini.librarybackend.domain.Book;
import com.stefanini.librarybackend.domain.History;
import com.stefanini.librarybackend.domain.User;
import com.stefanini.librarybackend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.stefanini.librarybackend.domain.enums.BookStatus.*;

@Service

public class BookServiceImpl implements BookService {
    @Autowired
    private final BookDAO<Book> bookDAOImpl;
    private final UserDAO<User> userDAOImpl;


    public BookServiceImpl(BookDAOImpl bookDAOImpl, UserDAO<User> userDAOImpl) {
        this.bookDAOImpl = bookDAOImpl;
        this.userDAOImpl = userDAOImpl;
    }


    @Override
    public Book addBook(Book book) {
        return bookDAOImpl.create(book);
    }

    @Override
    public List<Book> showAllBooks() {
        return bookDAOImpl.getAll();
    }

    @Override
    public Book update(int id, Book book) {
        Book updatedBook = bookDAOImpl.getById(id);
        updatedBook.setTitle(book.getTitle());
        updatedBook.setDescription(book.getDescription());
        updatedBook.setShelfNumber(book.getShelfNumber());
        updatedBook.setStatus(book.getStatus());
        return bookDAOImpl.update(updatedBook);
    }


    @Override
    public Book findById(int id) {
        return bookDAOImpl.getById(id);
    }


    @Override
    public int deleteBook(int id) {
        return bookDAOImpl.removeById(id);

    }

    @Override
    public Book bookTheBook(int bookId, int userId) {
        User user = userDAOImpl.getById(userId);
        Book book = bookDAOImpl.getById(bookId);
        book.setStatus(BOOKED);
        book.setUser(user);
        String actionName = "The book " + book.getTitle() + " was reserved";
        History history = new History();
        history.setActionName(actionName);
        history.setBook(book);
       history.setUser(user);
        List<History> bookHistoryList = book.getHistory();
        bookHistoryList.add(history);
        book.setHistory(bookHistoryList);
        List<History> userHistoryList = user.getHistory();
        userHistoryList.add(history);
        user.setHistory(userHistoryList);
        userDAOImpl.update(user);
        return bookDAOImpl.update(book);
    }

    @Override
    public Book giveTheBook(int bookId, int userId) {
        User user = userDAOImpl.getById(userId);
        Book book = bookDAOImpl.getById(bookId);
        book.setStatus(TAKEN);
        book.setUser(user);
        String actionName = "The book " + book.getTitle() + " was taken";
        History history = new History();
        history.setActionName(actionName);
        history.setBook(book);
        history.setUser(user);
        List<History> bookHistoryList = book.getHistory();
        bookHistoryList.add(history);
        book.setHistory(bookHistoryList);
        List<History> userHistoryList = user.getHistory();
        userHistoryList.add(history);
        user.setHistory(userHistoryList);
        userDAOImpl.update(user);
        return bookDAOImpl.update(book);
    }

    @Override
    public Book returnTheBook(int bookId) {
        Book book = bookDAOImpl.getById(bookId);
        User user = book.getUser();
        String actionName = "The book " + book.getTitle() + " was returned";
        History history = new History();
        history.setActionName(actionName);
        history.setBook(book);
        history.setUser(user);
        List<History> bookHistoryList = book.getHistory();
        bookHistoryList.add(history);
        book.setHistory(bookHistoryList);
        List<History> userHistoryList = user.getHistory();
        userHistoryList.add(history);
        user.setHistory(userHistoryList);
        book.setStatus(AVAILABLE);
        book.setUser(null);
        userDAOImpl.update(user);
        return bookDAOImpl.update(book);
    }

    @Override
    public List<Book> findBooksByAnyCriteria(String criteria) {
        return bookDAOImpl.getBooksByAnyCriteria(criteria);
    }

}
