package com.JavaBootcamp03.mobilestore.service;

import com.JavaBootcamp03.mobilestore.dto.SubCategoryDTO;
import com.JavaBootcamp03.mobilestore.entity.SubCategoryEntity;
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

    @Override
    public SubCategoryEntity getSubCatById(int id){
        return subCategoryRepository.findById(id);
    }

    @Override
    public SubCategoryEntity getSubCatByName(String name){
        return subCategoryRepository.findByName(name);
    }

    @Override
    public List<SubCategoryEntity> findAll(){
        return subCategoryRepository.findAll();
    }

    @Override
    public SubCategoryEntity createSubCat(SubCategoryDTO subCatDTO){
        SubCategoryEntity subCat = new SubCategoryEntity();

        subCat.setName(subCatDTO.getName());
        subCat.setDescription(subCatDTO.getDescription());

        return subCategoryRepository.save(subCat);
    }

    @Override
    public SubCategoryEntity updateSubCat(int id, SubCategoryDTO subCatDTO){
        SubCategoryEntity subCat = subCategoryRepository.findById(id);

        subCat.setName(subCatDTO.getName());
        subCat.setDescription(subCatDTO.getDescription());

        return subCategoryRepository.save(subCat);
    }

    @Override
    public void deleteSubCat(int id){
        subCategoryRepository.deleteById(id);
    }
}