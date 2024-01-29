package com.JavaBootcamp03.mobilestore.repository;

import com.JavaBootcamp03.mobilestore.entity.CategoryEntity;
import com.JavaBootcamp03.mobilestore.entity.SubCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategoryEntity,Integer> {
    List<SubCategoryEntity>findAllByCategory_Id(int id_category);


}