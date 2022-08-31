package com.stefanini.librarybackend.dao;


public interface EmailConfirmationTokenDAO<ConfirmationToken> extends IGenericDao<ConfirmationToken> {


    ConfirmationToken findByToken(String token);
}
