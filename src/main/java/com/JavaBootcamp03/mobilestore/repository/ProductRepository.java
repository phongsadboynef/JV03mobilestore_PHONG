package com.JavaBootcamp03.mobilestore.repository;

import com.JavaBootcamp03.mobilestore.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {
}
