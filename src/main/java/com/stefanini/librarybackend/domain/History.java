package com.stefanini.librarybackend.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "history")
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class History implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "actionName")
    private String actionName;

    @CreationTimestamp
    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonView
  //  @JsonBackReference(value="user-history")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonView
  //  @JsonBackReference(value="book-history")
    private Book book;

    History(int id, String actionName, Date date) {
        this.id = id;
        this.actionName = actionName;
        this.date = date;
    }

    History(String actionName, Date date) {
        this.actionName = actionName;
        this.date = date;
    }
}