package com.JavaBootcamp03.mobilestore.controller;

import com.JavaBootcamp03.mobilestore.dto.ReviewDTO;
import com.JavaBootcamp03.mobilestore.entity.ReviewEntity;
import com.JavaBootcamp03.mobilestore.service.serviceInterface.ReviewService;
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
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ModelMapper modelMapper;

    private Logger logger = LoggerFactory.getLogger(CustomerController.class);

    public ReviewController(ReviewService reviewService) {
        super();
        this.reviewService = reviewService;
    }

    @GetMapping("/list")
    public List<ReviewDTO> getReviews(){
        logger.info("Reviews are retrieved");
        return reviewService.getAllReview()
                .stream().map(reviewList -> modelMapper.map(reviewList, ReviewDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewDTO> getReviewById(@PathVariable(name ="id") int id){
        logger.info("Review is retrieved");
        ReviewEntity reviewEntity = reviewService.getReviewById(id);

        ReviewDTO reviewDTO = modelMapper.map(reviewEntity, ReviewDTO.class);

        return new ResponseEntity<ReviewDTO>(reviewDTO, HttpStatus.OK);
    }

    @GetMapping("/title/{reviewTitle}")
    public ResponseEntity<ReviewDTO> getReviewByTitle(@PathVariable(name ="reviewTitle") String reviewTitle){
        logger.info("Review is retrieved");
        ReviewEntity reviewEntity = reviewService.getReviewByTitle(reviewTitle);

        ReviewDTO reviewDTO = modelMapper.map(reviewEntity, ReviewDTO.class);

        return new ResponseEntity<ReviewDTO>(reviewDTO, HttpStatus.OK);
    }

    @GetMapping("/name/{reviewName}")
    public ResponseEntity<ReviewDTO> getReviewByReviewName(@PathVariable(name ="reviewName") String reviewName){
        logger.info("Review is retrieved");
        ReviewEntity reviewEntity = reviewService.getReviewByReviewName(reviewName);

        ReviewDTO reviewDTO = modelMapper.map(reviewEntity, ReviewDTO.class);

        return new ResponseEntity<ReviewDTO>(reviewDTO, HttpStatus.OK);
    }

    @GetMapping("/email/{reviewEmail}")
    public ResponseEntity<ReviewDTO> getReviewByReviewEmail(@PathVariable(name ="reviewEmail") String reviewEmail){
        logger.info("Review is retrieved");
        ReviewEntity reviewEntity = reviewService.getReviewByReviewEmail(reviewEmail);

        ReviewDTO reviewDTO = modelMapper.map(reviewEntity, ReviewDTO.class);

        return new ResponseEntity<ReviewDTO>(reviewDTO, HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<List<ReviewDTO>> getReviewByProductId(@PathVariable(name ="id") int id){
        logger.info("Review is retrieved");
        List<ReviewEntity> reviewEntity = reviewService.getAllReviewByProductId(id);

        List<ReviewDTO> reviewDTO = reviewEntity.stream().map(list -> modelMapper.map(list, ReviewDTO.class))
                .collect(Collectors.toList());

        return new ResponseEntity<List<ReviewDTO>>(reviewDTO, HttpStatus.OK);
    }

    @PostMapping("/create/{productId}")
    public ResponseEntity<ReviewDTO> createReview(@PathVariable(name ="productId") int productId, @RequestBody ReviewDTO reviewDTO){
        logger.info("Review is created");

        ReviewEntity review = reviewService.createReviewByProductId(productId, reviewDTO);

        ReviewDTO reviewResponse = modelMapper.map(review, ReviewDTO.class);

        return new ResponseEntity<ReviewDTO>(reviewResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewDTO> updateReview(@PathVariable(name ="id") int id, @RequestBody ReviewDTO reviewDTO) {
        logger.info("Review is updated");

        ReviewEntity review = reviewService.updateReview(id, reviewDTO);

        ReviewDTO reviewResponse = modelMapper.map(review, ReviewDTO.class);

        return new ResponseEntity<ReviewDTO>(reviewResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ReviewDTO> deleteReview(@PathVariable(name ="id") int id) {
        logger.info("Review is deleted");

        reviewService.deleteReview(id);

        return new ResponseEntity<ReviewDTO>(HttpStatus.OK);
    }
}
