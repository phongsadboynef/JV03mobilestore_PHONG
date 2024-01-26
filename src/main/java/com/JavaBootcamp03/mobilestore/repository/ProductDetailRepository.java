package com.JavaBootcamp03.mobilestore.repository;
import com.JavaBootcamp03.mobilestore.entity.ProductDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailRepository extends JpaRepository<ProductDetailEntity, Integer> {
}
