package com.stefanini.librarybackend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "category")
@Getter @Setter @NoArgsConstructor
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoryId_generator")
    @SequenceGenerator(name = "categoryId_generator", sequenceName = "categoryId_generator", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToMany(mappedBy = "categories")
    private List<Book> books;

    public Category(int id, String title, List<Book> books) {
        setId(id);
        setTitle(title);
        setBooks(books);
    }

    public Category(int id, String title) {
        setId(id);
        setTitle(title);
    }

    public Category(String title, List<Book> books) {
        setTitle(title);
        setBooks(books);
    }

    public Category(String title) {
        setTitle(title);
    }
}