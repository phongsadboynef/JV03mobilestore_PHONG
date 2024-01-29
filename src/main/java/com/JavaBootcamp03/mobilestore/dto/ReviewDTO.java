package com.JavaBootcamp03.mobilestore.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Data
@Getter
@Setter
public class ReviewDTO implements Serializable {
    private int id;
    private String reviewTitle;
    private String reviewContent;
    private String reviewName;
    private String reviewEmail;
    private int reviewRating;
    private ProductDTO productReview;
}
