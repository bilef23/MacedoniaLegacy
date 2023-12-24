package mk.finki.ukim.diansproject.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import mk.finki.ukim.diansproject.model.CulturalPlace;
import mk.finki.ukim.diansproject.model.User;
import mk.finki.ukim.diansproject.model.UserReview;

import java.util.List;

public interface ReviewService {
    void deleteById(Long id);
    UserReview getCommentById(Long id);
    void createReview(String comment, Integer rating, User user, CulturalPlace culturalPlace);
    void updateReview(String comment, Integer rating, User user, CulturalPlace culturalPlace);
    List<UserReview> getAll();
    List<UserReview> getAllReviewsByCulturalPlaceId(Long id);
    List<UserReview> getAllReviewsByUser_Username(String username);
}
