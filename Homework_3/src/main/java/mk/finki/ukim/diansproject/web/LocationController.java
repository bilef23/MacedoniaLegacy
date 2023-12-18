package mk.finki.ukim.diansproject.web;

import mk.finki.ukim.diansproject.service.CulturalPlaceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/loc")
public class LocationController {
    private final CulturalPlaceService culturalPlaceService;

    public LocationController(CulturalPlaceService culturalPlaceService) {
        this.culturalPlaceService = culturalPlaceService;
    }
}
