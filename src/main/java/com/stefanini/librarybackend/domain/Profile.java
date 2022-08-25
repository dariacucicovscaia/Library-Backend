package com.stefanini.librarybackend.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "profile")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Profile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

<<<<<<< HEAD

  /*  @OneToOne
    @JoinColumn(name = "user_id")
    private User user;*/

=======
>>>>>>> 0eb17c67b02e8eccd12b20ab6f932f0296ce86ae
    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    public Profile(String firstName, String lastName, String phoneNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
    }


}