package com.JavaBootcamp03.mobilestore.dto;
import lombok.Data;
import java.io.Serializable;

@Data
public class CategoryDTO implements Serializable {
    private int id;
    private String categoryName;
    private String description;
}
