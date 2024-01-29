package com.JavaBootcamp03.mobilestore.service.serviceInterface;

import com.JavaBootcamp03.mobilestore.entity.ProductEntity;

import java.util.List;

public interface ProductServiceImp {
    List<ProductEntity> getAllProduct();

    ProductEntity getProductById(int id);

    List <ProductEntity> getAllRelatedProduct(int idsubCat);
}
