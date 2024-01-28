package mk.finki.ukim.diansproject.service.impl;

import mk.finki.ukim.diansproject.model.CulturalPlace;
import mk.finki.ukim.diansproject.model.User;
import mk.finki.ukim.diansproject.model.UserReview;
import mk.finki.ukim.diansproject.repository.ReviewRepository;
import mk.finki.ukim.diansproject.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public UserReview getCommentById(Long id) {
        return reviewRepository.findById(id).orElseThrow();
    }

    @Override
    public void createReview(String comment, Integer rating, User user, CulturalPlace culturalPlace) {
        this.reviewRepository.save(new UserReview(comment,rating,user,culturalPlace));
    }

    @Override
    public void updateReview(String comment, Integer rating, User user, CulturalPlace culturalPlace) {
        UserReview userReview = this.reviewRepository.findByCulturalPlace_IdAndUser_Username(culturalPlace.getId(),user.getUsername());
        userReview.setRating(rating);
        userReview.setComment(comment);
    }

    @Override
    public List<UserReview> getAll() {
        return this.reviewRepository.findAll();
    }

    @Override
    public List<UserReview> getAllReviewsByCulturalPlaceId(Long id) {
        return this.reviewRepository.findByCulturalPlace_Id(id);
    }

    @Override
    public List<UserReview> getAllReviewsByUser_Username(String username) {
        return this.reviewRepository.findByUser_username(username);
    }
}