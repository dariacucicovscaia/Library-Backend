package com.stefanini.librarybackend.domain;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "book")
@Getter @Setter @NoArgsConstructor
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookId_generator")
    @SequenceGenerator(name = "bookId_generator", allocationSize = 1)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "bookDescription")
    private String description;

    @Column(name = "shelfNumber")
    private String shelfNumber;

    @Column(name = "bookStatus")
    private String status;

    @Column(name = "createdOn")
    private Date createdOn;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Category> categories;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Author> authors;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<History> history;

    public Book(int id, String title, String description, String shelfNumber, String status, Date createdOn) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.shelfNumber = shelfNumber;
        this.status = status;
        this.createdOn = createdOn;
    }

    public Book(String title, String description, String shelfNumber, String status, Date createdOn) {
        this.title = title;
        this.description = description;
        this.shelfNumber = shelfNumber;
        this.status = status;
        this.createdOn = createdOn;
    }

    public Book(String title, String description, String shelfNumber) {
        this.title = title;
        this.description = description;
        this.shelfNumber = shelfNumber;
    }

}