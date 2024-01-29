package com.JavaBootcamp03.mobilestore.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity(name = "review")
public class ReviewEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "reviewTitle")
    public String reviewTitle;

    @Column(name = "reviewContent")
    public String reviewContent;

    @Column(name = "reviewName")
    public String reviewName;

    @Column(name = "reviewEmail")
    public String reviewEmail;

    @Column(name = "reviewRating")
    public int reviewRating;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private ProductEntity productReview;
}
