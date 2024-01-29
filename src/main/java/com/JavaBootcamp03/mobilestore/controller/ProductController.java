//package com.JavaBootcamp03.mobilestore.controller;
//
//
//import com.JavaBootcamp03.mobilestore.entity.ProductEntity;
//import com.JavaBootcamp03.mobilestore.service.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/products")
//public class ProductController {
//
//    private final ProductService productService;
//
//    @Autowired
//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }
//
//    @GetMapping
//    public List<ProductEntity> findAll() {
//        return productService.findAll();
//    }
//
//    @GetMapping("/product/{id}")
//    public ResponseEntity<ProductEntity> findById(@PathVariable int id) {
//        return productService.findById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public ProductEntity createProduct(@RequestBody ProductEntity product) {
//        return productService.save(product);
//    }
//
//    @PutMapping("/product-save/{id}")
//    public ResponseEntity<ProductEntity> save(@PathVariable int id, @RequestBody ProductEntity product) {
//        return productService.findById(id)
//                .map(existingProduct -> {
//                    product.setId(id);
//                    return ResponseEntity.ok(productService.save(product));
//                })
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/product-delete/{id}")
//    public ResponseEntity<Void> deleteById(@PathVariable int id) {
//        if (!productService.findById(id).isPresent()) {
//            return ResponseEntity.notFound().build();
//        }
//        productService.deleteById(id);
//        return ResponseEntity.ok().build();
//    }
//}