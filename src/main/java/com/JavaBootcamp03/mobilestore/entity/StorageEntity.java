package com.JavaBootcamp03.mobilestore.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity(name = "storage")
public class StorageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "storageName")
    private String storage;

    @OneToMany(mappedBy = "storage")
    private List<ProductDetailEntity> productDetails;
}
