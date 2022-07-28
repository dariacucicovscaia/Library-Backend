package com.stefanini.librarybackend;


import com.stefanini.librarybackend.dao.UserDAO;
import com.stefanini.librarybackend.domain.Book;
import com.stefanini.librarybackend.domain.User;
import com.stefanini.librarybackend.helper.HibernateUtil;
import com.stefanini.librarybackend.service.BookServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@SpringBootApplication
@EnableAutoConfiguration
public class LibraryBackendApplication {

    public static void main(String[] args) {
       SpringApplication.run(LibraryBackendApplication.class, args);

    }

}