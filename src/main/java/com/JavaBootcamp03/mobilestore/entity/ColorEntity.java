package com.JavaBootcamp03.mobilestore.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity(name = "color")
public class ColorEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(name = "colorName")
        private String color;

        @OneToMany(mappedBy = "color")
        private List<ProductDetailEntity> productDetails;
}
