package com.JavaBootcamp03.mobilestore.service.serviceInterface;

import com.JavaBootcamp03.mobilestore.entity.ReviewEntity;
import com.JavaBootcamp03.mobilestore.dto.ReviewDTO;

import java.util.List;

public interface ReviewService {
    List<ReviewEntity> getAllReview();

    ReviewEntity getReviewById(int id);

    ReviewEntity getReviewByTitle(String title);

    ReviewEntity getReviewByReviewName(String reviewName);

    ReviewEntity getReviewByReviewEmail(String reviewEmail);

    List<ReviewEntity> getAllReviewByProductId(int id);

    ReviewEntity createReviewByProductId(int productId, ReviewDTO reviewDTO);

    ReviewEntity updateReview(int id, ReviewDTO reviewDTO);

    void deleteReview(int id);
}
