package com.stefanini.librarybackend.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userId_generator")
    @SequenceGenerator(name = "userId_generator", allocationSize = 1)
    @Column(unique = true, name = "id", nullable = false)
    private Long id;

    @Column(unique = true, name = "email", nullable = false)
    private String email;
    @Column( name = "password", nullable = false)
    private String password;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + "\'" + "password='" + password + "\'" +
                '}';
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     *

    @Transient
    private UserRole userRole;
    @Transient
    private Profile profile;

    public UserRole getUserRole() {
        return userRole;
    }

    public Profile getProfile() {
        return profile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }  */
}