package com.JavaBootcamp03.mobilestore.controller;

import com.JavaBootcamp03.mobilestore.dto.SubCategoryDTO;
import com.JavaBootcamp03.mobilestore.entity.SubCategoryEntity;
import com.JavaBootcamp03.mobilestore.service.serviceInterface.SubCategoryServiceImp;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/subCat")
public class SubCatController {
    @Autowired
    private SubCategoryServiceImp subCatServiceImp;

    private ModelMapper modelMapper;

    private Logger logger = LoggerFactory.getLogger(CustomerController.class);

    public SubCatController(SubCategoryServiceImp subCatServiceImp, ModelMapper modelMapper){
        super();
        this.subCatServiceImp = subCatServiceImp;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/list")
    public List<SubCategoryDTO> getSubCats(){
        logger.info("SubCats are retrieved");

        return subCatServiceImp.findAll()
                .stream().map(subCatList -> modelMapper.map(subCatList, SubCategoryDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubCategoryDTO> getSubCatById(@PathVariable(name ="id") int id) {
        logger.info("SubCat is retrieved");
        SubCategoryEntity subCatEntity = subCatServiceImp.getSubCatById(id);

        SubCategoryDTO subCatDTO = modelMapper.map(subCatEntity, SubCategoryDTO.class);

        return new ResponseEntity<SubCategoryDTO>(subCatDTO, HttpStatus.OK);
    }
}
