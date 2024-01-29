package com.JavaBootcamp03.mobilestore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "catName")
    private String name;

    @Column(name = "catDescription")
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<SubCategoryEntity> subCategory;
}
