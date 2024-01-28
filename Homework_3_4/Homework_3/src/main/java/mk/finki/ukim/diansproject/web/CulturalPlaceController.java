package mk.finki.ukim.diansproject.web;

import com.opencsv.exceptions.CsvException;
import mk.finki.ukim.diansproject.model.CulturalPlace;
import mk.finki.ukim.diansproject.model.User;
import mk.finki.ukim.diansproject.model.UserReview;
import mk.finki.ukim.diansproject.service.CulturalPlaceService;
import mk.finki.ukim.diansproject.service.ReviewService;
import mk.finki.ukim.diansproject.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/places")
public class CulturalPlaceController {
    @Autowired
    private  RestTemplate restTemplate;
    private final CulturalPlaceService culturalPlaceService;
    private final ReviewService reviewService;
    private final UserService userService;

    public CulturalPlaceController(RestTemplate restTemplate, CulturalPlaceService culturalPlaceService, ReviewService reviewService, UserService userService) {
        this.restTemplate = restTemplate;
        this.culturalPlaceService = culturalPlaceService;

        this.reviewService = reviewService;
        this.userService = userService;
    }

    @GetMapping()
    public ModelAndView getMainPage(Model model) throws IOException, CsvException {
        ResponseEntity<List<CulturalPlace>> response = restTemplate.exchange(
                "http://localhost:8082/places",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });


        List<CulturalPlace> places = response.getBody();
        model.addAttribute("places", places);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }


    @GetMapping("/additional-information/{id}")
    public ResponseEntity<Map<String, Object>> getAdditionalInfo(@PathVariable Long id) {
        ResponseEntity<Map<String, Object>> response = restTemplate.exchange(
                "http://localhost:8082/places/additional-information/"+id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Map<String, Object>>() {},
                id);

        return response;
    }
    @PostMapping("/add-review/{id}")
    public  ResponseEntity<String> userReview(@PathVariable Long id,
                                              @RequestParam String comment,
                                              @RequestParam Integer rate,
                                              @NotNull @AuthenticationPrincipal UserDetails userDetails){
        CulturalPlace p=culturalPlaceService.findById(id);
        User u=(User)userService.loadUserByUsername(userDetails.getUsername());
        reviewService.createReview(comment,rate,u,p);
        URI location = URI.create("/places");
        return ResponseEntity.status(HttpStatus.SEE_OTHER).location(location).build();
    }
    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteObject(@PathVariable Long id){
        CulturalPlace p=culturalPlaceService.findById(id);
        culturalPlaceService.deleteObject(p);
        URI location = URI.create("/places");
        return ResponseEntity.status(HttpStatus.SEE_OTHER).location(location).build();

    }
    @GetMapping("/listPlaces")
    public ModelAndView filterPlaces(@RequestParam(required = false) String category,
                                     @RequestParam(required = false) String searchName,
                                     @RequestParam(required = false) String searchLocation,
                                     Model model) throws IOException, InterruptedException {
        ResponseEntity<List<CulturalPlace>> response = restTemplate.exchange(
                "http://localhost:8082/places/filter?category="+category+"&searchName="+searchName+"&searchLocation="+searchLocation,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });


        List<CulturalPlace> places = response.getBody();

        model.addAttribute("places",places);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        return modelAndView;
    }

}