package com.stefanini.librarybackend.dao;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// THIS IS FOR GENERIC TESTING
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BasicEntityTest {

    @Id
    @GeneratedValue
    private int id;
    private String name;
}
