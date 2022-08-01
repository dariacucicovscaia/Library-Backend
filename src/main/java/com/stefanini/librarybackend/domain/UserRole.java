package com.stefanini.librarybackend.domain;

import com.stefanini.librarybackend.domain.enums.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "role")

public class UserRole implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToMany(mappedBy = "userRole")
    private List<User> users;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;


}