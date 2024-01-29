package com.JavaBootcamp03.mobilestore.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "images")
    private String images;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "id_subCat")
    private SubCategoryEntity subCategory;
}
