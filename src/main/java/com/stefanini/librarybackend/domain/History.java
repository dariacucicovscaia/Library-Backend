package com.stefanini.librarybackend.domain;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "historyId_generator")
    @SequenceGenerator(name = "historyId_generator", allocationSize = 1)
    @Column(name = "id")
    private int id;
    @Column(name = "actionName")
    private String actionName;
    @Column(name = "date")
    private Date date;
     @ManyToOne
    @JoinColumn(name = "user_id")
     private User user;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    History(){

    };
    History(int id, String actionName, Date date ){
        this.id=id;
        this.actionName = actionName;
        this.date = date;
    }
    History(String actionName, Date date ){
        this.actionName = actionName;
        this.date = date;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}