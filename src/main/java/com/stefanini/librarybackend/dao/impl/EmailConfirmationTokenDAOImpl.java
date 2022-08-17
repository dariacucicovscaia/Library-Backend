package com.stefanini.librarybackend.dao.impl;

import com.stefanini.librarybackend.dao.EmailConfirmationTokenDAO;
import com.stefanini.librarybackend.domain.ConfirmationToken;

public class EmailConfirmationTokenDAOImpl extends DAOAbstractImpl<ConfirmationToken> implements EmailConfirmationTokenDAO<ConfirmationToken> {

    public EmailConfirmationTokenDAOImpl() {
        setClazz(ConfirmationToken.class);
    }
}
