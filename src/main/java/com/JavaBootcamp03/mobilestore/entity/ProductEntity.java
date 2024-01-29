package com.JavaBootcamp03.mobilestore.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@Entity(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "images")
    private String images;

    @Column(name = "title")
    private String title;

    @Column(name = "createdAt")
    private String createdAt;

    @Column(name = "deletedAt")
    private String deletedAt;

    @ManyToOne
    @JoinColumn(name = "id_subCat")
    private SubCategoryEntity productSubCat;
}
