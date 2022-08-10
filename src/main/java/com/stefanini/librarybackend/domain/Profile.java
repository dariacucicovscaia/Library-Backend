package com.stefanini.librarybackend.domain;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor

@Entity
@Table(name = "profile")
public class Profile implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

   /* @OneToOne(mappedBy = "profile")
    private User user;*/

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName ;

    @Column(name = "phoneNumber")
    private String  phoneNumber;

    public Profile(String firstName, String lastName, String phoneNumber){
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
    }




}