package com.stefanini.librarybackend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "user_role")
public class UserRole implements Serializable {
    public enum Role {
        USER, LIBRARIAN, ADMIN;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userRoleId_generator")
    @SequenceGenerator(name = "userRoleId_generator", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "role")
    @Enumerated(EnumType.ORDINAL)
    private Role role;


}