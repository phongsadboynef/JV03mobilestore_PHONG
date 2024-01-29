package com.JavaBootcamp03.mobilestore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "subCategory")
public class SubCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "subCatName")
    private String name;

    @Column(name = "subCatDescription")
    private String description;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_category")
    private CategoryEntity category;

    @OneToMany(mappedBy = "subCategory")
    private List<ProductEntity> product;

}
