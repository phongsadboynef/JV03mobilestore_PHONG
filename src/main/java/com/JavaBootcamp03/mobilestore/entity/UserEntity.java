package com.JavaBootcamp03.mobilestore.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "usrFirstName")
    private String firstName;

    @Column(name = "usrLastName")
    private String lastName;

    @Column(name = "usrDOB")
    private java.sql.Date dob;

    @Column(name = "usrGender")
    private int gender;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private RoleEntity roleUser;
}
