package com.JavaBootcamp03.mobilestore.service;

import com.JavaBootcamp03.mobilestore.entity.ProductEntity;
import com.JavaBootcamp03.mobilestore.service.serviceInterface.ReviewService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.JavaBootcamp03.mobilestore.repository.ReviewRepository;
import com.JavaBootcamp03.mobilestore.entity.ReviewEntity;
import com.JavaBootcamp03.mobilestore.dto.ReviewDTO;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class ReviewServiceImp implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductService productService;

    public ReviewServiceImp(ReviewRepository reviewRepository) {
        super();
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<ReviewEntity> getAllReview() {
        return reviewRepository.findAll();
    }

    @Override
    public ReviewEntity getReviewById(int id) {
        return reviewRepository.findById(id);
    }

    @Override
    public ReviewEntity getReviewByTitle(String reviewTitle) {
        return reviewRepository.findByReviewTitle(reviewTitle);
    }

    @Override
    public ReviewEntity getReviewByReviewName(String reviewName) {
        return reviewRepository.findByReviewName(reviewName);
    }

    @Override
    public ReviewEntity getReviewByReviewEmail(String reviewEmail) {
        return reviewRepository.findByReviewEmail(reviewEmail);
    }

    @Override
    public List<ReviewEntity> getAllReviewByProductId(int id) {
        ProductEntity productEntity = productService.getProductById(id);

        int idProduct = productEntity.getId();

        return reviewRepository.findAllByProductReview_Id(idProduct);
    }

    @Override
    public ReviewEntity createReviewByProductId(int productId, ReviewDTO reviewDTO) {
        ReviewEntity review = new ReviewEntity();

        review.setReviewTitle(reviewDTO.getReviewTitle());
        review.setReviewContent(reviewDTO.getReviewContent());
        review.setReviewName(reviewDTO.getReviewName());
        review.setReviewEmail(reviewDTO.getReviewEmail());
        review.setReviewRating(reviewDTO.getReviewRating());

        ProductEntity productEntity = productService.getProductById(productId);
        int idProduct = productEntity.getId();
        review.setProductReview(productEntity);

        return reviewRepository.save(review);
    }

    @Override
    public ReviewEntity updateReview(int id, ReviewDTO reviewDTO) {
        ReviewEntity review = reviewRepository.findById(id);

        if(review != null) {
            review.setReviewTitle(reviewDTO.getReviewTitle());
            review.setReviewContent(reviewDTO.getReviewContent());
            review.setReviewName(reviewDTO.getReviewName());
            review.setReviewEmail(reviewDTO.getReviewEmail());
            review.setReviewRating(reviewDTO.getReviewRating());

            return reviewRepository.save(review);
        }

        return null;
    }

    @Override
    public void deleteReview(int id) {
        ReviewEntity review = reviewRepository.findById(id);

        if(review != null) {
            reviewRepository.delete(review);
        }
    }
}
