package com.JavaBootcamp03.mobilestore.service.serviceInterface;

import com.JavaBootcamp03.mobilestore.entity.ProductDetailEntity;

import java.util.List;

public interface ProductDetailServiceImp {
    List<ProductDetailEntity> findAll();

    ProductDetailEntity findById(int id);

    ProductDetailEntity save(ProductDetailEntity productDetail);
}
