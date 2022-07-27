package com.stefanini.librarybackend;


import com.stefanini.librarybackend.dao.DAOAbstractImpl;
import com.stefanini.librarybackend.dao.IGenericDao;
import com.stefanini.librarybackend.dao.UserDAO;
import com.stefanini.librarybackend.domain.Author;
import com.stefanini.librarybackend.domain.User;
import com.stefanini.librarybackend.helper.HibernateUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
@EnableAutoConfiguration
public class LibraryBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryBackendApplication.class, args);
    }

}