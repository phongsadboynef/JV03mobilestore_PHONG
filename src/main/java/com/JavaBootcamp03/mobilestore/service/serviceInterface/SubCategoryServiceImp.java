package com.JavaBootcamp03.mobilestore.service.serviceInterface;

import com.JavaBootcamp03.mobilestore.dto.SubCategoryDTO;
import com.JavaBootcamp03.mobilestore.entity.SubCategoryEntity;

import java.util.List;

public interface SubCategoryServiceImp {
    List<SubCategoryDTO> getSubCategory(int id_category);

    SubCategoryEntity getSubCatById(int id);

    SubCategoryEntity getSubCatByName(String name);

    List<SubCategoryEntity> findAll();

    SubCategoryEntity createSubCat(SubCategoryDTO subCatDTO);

    SubCategoryEntity updateSubCat(int id, SubCategoryDTO subCatDTO);

    void deleteSubCat(int id);
}
