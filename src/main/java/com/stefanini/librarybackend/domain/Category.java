package com.stefanini.librarybackend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "category")
@Getter @Setter @NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoryId_generator")
    @SequenceGenerator(name = "categoryId_generator", sequenceName = "categoryId_generator", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

   /* @ManyToMany(mappedBy = "categories")
    private List<Book> books;*/

  /*  public Category(int id, String title, String description, List<Book> books) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.books = books;
    }*/

    public Category(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

   /* public Category(String title, String description, List<Book> books) {
        this.title = title;
        this.description = description;
        this.books = books;
    }*/

    public Category(String title, String description) {
        this.title = title;
        this.description = description;
    }
}