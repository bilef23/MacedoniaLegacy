package mk.finki.ukim.diansproject.web;

import mk.finki.ukim.diansproject.service.CulturalPlaceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/loc")
public class LocationController {
    private final CulturalPlaceService culturalPlaceService;

    public LocationController(CulturalPlaceService culturalPlaceService) {
        this.culturalPlaceService = culturalPlaceService;
    }
    @PostMapping("/receiveLoc")
    public String receiveLocation(@RequestParam String latitude,
                                  @RequestParam String longitude,
                                  @RequestParam String placeId){
        System.out.println("OK");
        return "redirect:/places";
    }
}
