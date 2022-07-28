package com.stefanini.librarybackend.domain;

import javax.persistence.*;

@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profileId_generator")
    @SequenceGenerator(name = "profileId_generator", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName ;

    @Column(name = "phoneNumber")
    private String  phoneNumber;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}