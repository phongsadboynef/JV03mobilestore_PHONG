package com.JavaBootcamp03.mobilestore.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity(name = "address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "addressName")
    private String addressName;

    @OneToMany(mappedBy = "address")
    private List<AddressDetailEntity> addressDetails;
}
