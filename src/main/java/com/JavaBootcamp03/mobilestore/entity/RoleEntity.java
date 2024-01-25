package com.JavaBootcamp03.mobilestore.entity;

import lombok.Data;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Setter
@Getter
@Entity(name = "role")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "roleUser")
    private List<UserEntity> users;

    @OneToMany(mappedBy = "roleCustomer")
    private List<CustomerEntity> customers;
}
