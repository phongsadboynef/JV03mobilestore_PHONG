package com.JavaBootcamp03.mobilestore.service;

import com.JavaBootcamp03.mobilestore.entity.ProductDetailEntity;
import com.JavaBootcamp03.mobilestore.repository.ProductDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDetailService {

    private final ProductDetailRepository productDetailRepository;

    @Autowired
    public ProductDetailService(ProductDetailRepository productDetailRepository) {
        this.productDetailRepository = productDetailRepository;
    }

    public List<ProductDetailEntity> findAll() {
        return productDetailRepository.findAll();
    }

    public Optional<ProductDetailEntity> findById(int id) {
        return productDetailRepository.findById(id);
    }

    public ProductDetailEntity save(ProductDetailEntity productDetail) {
        return productDetailRepository.save(productDetail);
    }

    public void deleteById(int id) {
        productDetailRepository.deleteById(id);
    }
}
