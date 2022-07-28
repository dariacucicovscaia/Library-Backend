package com.stefanini.librarybackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.PersistenceContext;
import java.util.Collections;


@SpringBootApplication
@EnableAutoConfiguration
public class LibraryBackendApplication {

    public static void main(String[] args) {

      SpringApplication.run(LibraryBackendApplication.class, args);
    }


}