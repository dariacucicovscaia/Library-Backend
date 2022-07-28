package com.stefanini.librarybackend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userId_generator")
    @SequenceGenerator(name = "userId_generator", allocationSize = 1)
    @Column(unique = true, name = "id", nullable = false)
    private int id;

    @Column(unique = true, name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Transient
    @OneToMany
    private List<UserRole> userRole;

    @Transient
    @OneToOne
    private Profile profile;

    @CreationTimestamp
    @Column(name = "created")
    private LocalDateTime created;

    @UpdateTimestamp
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @OneToMany
    private List<Book> book;

    public User(int id, String email, String password) {
        setId(id);
        setEmail(email);
        setPassword(password);
    }

    public User(String email, String password, Profile profile) {
        setId(id);
        setEmail(email);
        setPassword(password);
        setProfile(profile);
    }

    public User(String email, String password) {
        setEmail(email);
        setPassword(password);
    }


}