package com.JavaBootcamp03.mobilestore.service;

import com.JavaBootcamp03.mobilestore.dto.SubCategoryDTO;
import com.JavaBootcamp03.mobilestore.entity.CategoryEntity;
import com.JavaBootcamp03.mobilestore.entity.SubCategoryEntity;
import com.JavaBootcamp03.mobilestore.repository.CategoryRepository;
import com.JavaBootcamp03.mobilestore.repository.SubCategoryRepository;
import com.JavaBootcamp03.mobilestore.service.serviceInterface.SubCategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SubCategoryService implements SubCategoryServiceImp {
    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Override
    public List<SubCategoryDTO> getSubCategory(int id_category) {
        //CategoryEntity cat = categoryRepository.findById(id_category);
        //CategoryEntity category = categoryRepository.findById(id_category);
        List<SubCategoryEntity> list = subCategoryRepository.findAllByCategory_Id(id_category);
        List<SubCategoryDTO> listDTO = new ArrayList<>();
        for (SubCategoryEntity item : list) {
            SubCategoryDTO subCategoryDTO = new SubCategoryDTO();
            subCategoryDTO.setId(item.getId());
            subCategoryDTO.setName(item.getName());
            subCategoryDTO.setDescription(item.getDescription());
            subCategoryDTO.setCategory(item.getCategory());
            listDTO.add(subCategoryDTO);
        }
        return listDTO;
    }
}