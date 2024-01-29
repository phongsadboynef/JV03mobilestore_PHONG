package com.JavaBootcamp03.mobilestore.repository;

import com.JavaBootcamp03.mobilestore.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer> {
    ReviewEntity findById(int id);

    ReviewEntity findByReviewTitle(String reviewTitle);

    ReviewEntity findByReviewName(String reviewName);

    ReviewEntity findByReviewEmail(String reviewEmail);

    List<ReviewEntity> findAllByProductReview_Id(int id);
}
