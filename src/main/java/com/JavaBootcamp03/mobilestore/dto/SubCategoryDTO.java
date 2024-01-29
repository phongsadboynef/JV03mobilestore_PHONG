package com.JavaBootcamp03.mobilestore.dto;

import com.JavaBootcamp03.mobilestore.entity.CategoryEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class SubCategoryDTO implements Serializable {
    private int id;
    private String name;
    private String description;
    private CategoryEntity category;
}