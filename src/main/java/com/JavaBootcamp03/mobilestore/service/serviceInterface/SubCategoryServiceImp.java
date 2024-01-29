package com.JavaBootcamp03.mobilestore.service.serviceInterface;

import com.JavaBootcamp03.mobilestore.dto.SubCategoryDTO;

import java.util.List;

public interface SubCategoryServiceImp {
    List<SubCategoryDTO> getSubCategory(int id_category);
}
