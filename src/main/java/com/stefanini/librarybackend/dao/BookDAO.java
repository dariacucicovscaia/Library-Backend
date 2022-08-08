package com.stefanini.librarybackend.dao;

public interface BookDAO<Book> extends IGenericDao<Book> {
    void updateStatusToBooked(String bookTitle, String bookStatus, String userId);

    void updateStatusToTaken(String bookTitle, String bookStatus, String userId);

    void updateStatusWhenReturned(String bookTitle);

}
