package com.JavaBootcamp03.mobilestore.controller;

import com.JavaBootcamp03.mobilestore.payload.response.*;
import com.JavaBootcamp03.mobilestore.service.serviceInterface.CategoryServiceImp;
import com.JavaBootcamp03.mobilestore.service.serviceInterface.SubCategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@CrossOrigin
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryServiceImp categoryServiceImp;

    @Autowired
    private SubCategoryServiceImp subCategoryServiceImp;

    @GetMapping("/getall")
    public ResponseEntity<?> getCategory() {
        ApiResponse baseResponse = new ApiResponse();
        baseResponse.setData(categoryServiceImp.getAllCategory());
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @PostMapping("/getsub")
    public ResponseEntity<?> getSubCategory(@RequestParam int id_category) {
        ApiResponse baseResponse = new ApiResponse();
        baseResponse.setData(subCategoryServiceImp.getSubCategory(id_category));
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }


}
