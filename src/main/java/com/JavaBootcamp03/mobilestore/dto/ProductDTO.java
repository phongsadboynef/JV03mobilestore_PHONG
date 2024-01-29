package com.JavaBootcamp03.mobilestore.dto;

import java.io.Serializable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ProductDTO implements Serializable {
    private int id;
    private String productTitle;
    private String images;
    private SubCategoryDTO productSubCat;
// sua lai entity va cai DTO
}
