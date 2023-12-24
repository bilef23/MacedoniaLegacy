package mk.finki.ukim.diansproject.web;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mk.finki.ukim.diansproject.model.CulturalPlace;
import mk.finki.ukim.diansproject.model.User;
import mk.finki.ukim.diansproject.model.UserReview;
import mk.finki.ukim.diansproject.repository.UserRepository;
import mk.finki.ukim.diansproject.service.CulturalPlaceService;

import mk.finki.ukim.diansproject.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("")
public class ReviewController {
    private final ReviewService reviewService;
    private final CulturalPlaceService culturalPlaceService;
    private final UserRepository userRepository;

    public ReviewController(ReviewService reviewService, CulturalPlaceService culturalPlaceService, UserRepository userRepository) {
        this.reviewService = reviewService;
        this.culturalPlaceService = culturalPlaceService;
        this.userRepository = userRepository;
    }
  /*  @GetMapping()
    public String getAllReviews(@RequestParam(required = false) String error, Model model){
        List<UserReview> reviews = this.reviewService.getAll();
        model.addAttribute("reviews", reviews);
        model.addAttribute("error", error);
        return "?";
    }


    @PostMapping("/{id}")
    @ResponseBody
    public List<UserReview> getAllCommentsForLocation(@PathVariable Long id, @RequestParam(required = false) String error,
                                                      Model model) throws JsonProcessingException {
        List<UserReview> reviews = this.reviewService.getAllReviewsByCulturalPlaceId(id);
        model.addAttribute("error", error);
        ObjectMapper objectMapper = new ObjectMapper();
        //Set pretty printing of json
//        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String arrayToJson = objectMapper.writeValueAsString(reviews);
        model.addAttribute("comments", arrayToJson);
        return reviews;
    }   */
   /* @GetMapping("/add-review/{id}")
    public String addCommentPage(@PathVariable(required = false) Long id,
                                 @RequestParam(required = false) String error, Model model){
        CulturalPlace culturalPlace = this.culturalPlaceService.findById(id);
        model.addAttribute("error", error);
        model.addAttribute("culturalPlace", culturalPlace);
        return "places" ;
    }

    */
    @PostMapping("/add-review/{id}")
    @ResponseBody
    public String createComment(@PathVariable String id,
                                @RequestParam("rate") Integer rating,
                                @RequestParam String comment,
                                @RequestParam String name, Model model,
                                @RequestParam(required = false) String error){
        CulturalPlace culturalPlace = this.culturalPlaceService.findById(Long.valueOf(id));
        model.addAttribute("error", error);
        model.addAttribute("culturalPlace", culturalPlace);
        User user = userRepository.findUserByUsername(name);
        this.reviewService.createReview(comment, rating , user, culturalPlace);
        return "redirect:/places";
    }
    @PostMapping("/delete-review/{id}")
    public String deleteCommentTestingTesting(@PathVariable String id){
//        String id = "5";
        this.reviewService.deleteById(Long.valueOf(id));
        return "redirect:/places";
    }
}
