package com.JavaBootcamp03.mobilestore.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity(name = "productdetail")
public class ProductDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_product_detail")
    private int idProductDetail;

    @Column(name = "id_color")
    private int idColor;

    @Column(name = "id_product")
    private int idProduct;

    @Column(name = "id_storage")
    private int idStorage;

    @Column(name = "id_promotion")
    private int idPromotion;

    @Column(name = "sku")
    private String sku;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_color")
    private ColorEntity color;

    @ManyToOne
    @JoinColumn(name = "id_storage")
    private StorageEntity storage;
}
