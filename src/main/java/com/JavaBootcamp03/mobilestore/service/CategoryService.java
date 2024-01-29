package com.JavaBootcamp03.mobilestore.service;
import com.JavaBootcamp03.mobilestore.dto.CategoryDTO;
import com.JavaBootcamp03.mobilestore.entity.CategoryEntity;
import com.JavaBootcamp03.mobilestore.repository.CategoryRepository;

import com.JavaBootcamp03.mobilestore.service.serviceInterface.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements CategoryServiceImp {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> getAllCategory() {
        List<CategoryEntity> list = categoryRepository.findAll();
        List<CategoryDTO> listDTO = new ArrayList<>();
        for (CategoryEntity item : list) {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(item.getId());
            categoryDTO.setCategoryName(item.getName());
            categoryDTO.setDescription(item.getDescription());
            listDTO.add(categoryDTO);
        }
        return listDTO;
    }
}