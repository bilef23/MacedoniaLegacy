package mk.finki.ukim.diansproject.cultural_place_microservice.web;


import mk.finki.ukim.diansproject.cultural_place_microservice.model.CulturalPlace;
import mk.finki.ukim.diansproject.cultural_place_microservice.model.User;
import mk.finki.ukim.diansproject.cultural_place_microservice.model.UserReview;
import mk.finki.ukim.diansproject.cultural_place_microservice.service.CulturalPlaceService;
import mk.finki.ukim.diansproject.cultural_place_microservice.service.ReviewService;
import mk.finki.ukim.diansproject.cultural_place_microservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/places")
public class CulturalPlaceController {
    private final CulturalPlaceService culturalPlaceService;
    private final ReviewService reviewService;
    private final UserService userService;

    public CulturalPlaceController(CulturalPlaceService culturalPlaceService, ReviewService reviewService, UserService userService) {
        this.culturalPlaceService = culturalPlaceService;
        this.reviewService = reviewService;
        this.userService = userService;
    }

    @GetMapping
    public List<CulturalPlace> getAllCulturalPlaces() {

        return culturalPlaceService.findAll();
    }

    @GetMapping("/filter")
    public List<CulturalPlace>  filterPlaces(@RequestParam(required = false) String category,
                                             @RequestParam(required = false) String searchName,
                                             @RequestParam(required = false) String searchLocation) throws IOException, InterruptedException {

         return this.culturalPlaceService.filter(searchName,category,searchLocation);
    }

    private double calculateAverageRating(List<UserReview> reviews) {
        if (reviews.isEmpty()) {
            return 0; // or any default value
        }

        int sum = 0;
        for (UserReview review : reviews) {
            sum += review.getRating();
        }

        return (double) sum / reviews.size();
    }
    @GetMapping("/additional-information/{id}")
    public Map<String, Object> getAdditionalInfo(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        CulturalPlace culturalPlace = culturalPlaceService.findById(id);
        if (culturalPlace != null) {
            int reviews = reviewService.getAllReviewsByCulturalPlaceId(id).size();
            double rating = calculateAverageRating(reviewService.getAllReviewsByCulturalPlaceId(id));

            response.put("number", culturalPlace.getPhoneNumber());
            response.put("reviews", reviews);
            response.put("rating", rating);
        } else {
            response.put("error", "Cultural place not found");
        }

        return response;
    }
}
