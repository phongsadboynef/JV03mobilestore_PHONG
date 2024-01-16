package com.JavaBootcamp03.mobilestore.entity;

import lombok.Data;
import jakarta.persistence.*;
import java.util.List;

@Data
@Entity(name = "roles")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "role") //Lưu ý : tên thuộc tính của entity bên UserEntity
    private List<UserEntity> users;

}
