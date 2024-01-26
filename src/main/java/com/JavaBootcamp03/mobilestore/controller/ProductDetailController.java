package com.JavaBootcamp03.mobilestore.controller;

import com.JavaBootcamp03.mobilestore.entity.ProductDetailEntity;
import com.JavaBootcamp03.mobilestore.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productdetails")
public class ProductDetailController {

    private final ProductDetailService productDetailService;

    @Autowired
    public ProductDetailController(ProductDetailService productDetailService) {
        this.productDetailService = productDetailService;
    }

    @GetMapping
    public List<ProductDetailEntity> getAllProductDetails() {
        return productDetailService.findAll();
    }

    @GetMapping("/productdetails/{id}")
    public ResponseEntity<ProductDetailEntity> getProductDetailById(@PathVariable int id) {
        return productDetailService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProductDetailEntity createProductDetail(@RequestBody ProductDetailEntity productDetail) {
        return productDetailService.save(productDetail);
    }

    @PutMapping("/productdetails-update/{id}")
    public ResponseEntity<ProductDetailEntity> updateProductDetail(@PathVariable int id, @RequestBody ProductDetailEntity productDetail) {
        return productDetailService.findById(id)
                .map(existingProductDetail -> {
                    productDetail.setId(id);
                    return ResponseEntity.ok(productDetailService.save(productDetail));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/productdetails-delete/{id}")
    public ResponseEntity<Void> deleteProductDetail(@PathVariable int id) {
        if (!productDetailService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        productDetailService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}