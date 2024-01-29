package com.JavaBootcamp03.mobilestore.service;

import com.JavaBootcamp03.mobilestore.entity.ProductEntity;
import com.JavaBootcamp03.mobilestore.entity.SubCategoryEntity;
import com.JavaBootcamp03.mobilestore.repository.ProductRepository;
import com.JavaBootcamp03.mobilestore.repository.SubCategoryRepository;
import com.JavaBootcamp03.mobilestore.service.serviceInterface.ProductServiceImp;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor
@Service
public class ProductService implements ProductServiceImp {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SubCategoryRepository subCatRepository;

    public ProductService(ProductRepository productRepository, SubCategoryRepository subCatRepository) {
        super();
        this.productRepository = productRepository;
        this.subCatRepository = subCatRepository;
    }

    @Override
    public List<ProductEntity> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public ProductEntity getProductById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public List<ProductEntity> getAllRelatedProduct(int idsubCat) {

        SubCategoryEntity SubCatEntity = subCatRepository.findById(idsubCat);
        int id = SubCatEntity.getId();

        return productRepository.findAllByProductSubCat_Id(id);
    }
}
