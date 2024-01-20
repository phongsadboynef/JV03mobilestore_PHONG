package com.JavaBootcamp03.mobilestore.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity(name = "customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "custFirstName")
    private String firstName;

    @Column(name = "custLastName")
    private String lastName;

    @Column(name = "custDOB")
    private java.sql.Date dob;

    @Column(name = "custGender")
    private int gender;

    @Column(name = "custRank")
    private String rank;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private RoleEntity roleCustomer;

    @OneToMany(mappedBy = "customerAddress")
    private List<AddressDetailEntity> addressDetails;
}
