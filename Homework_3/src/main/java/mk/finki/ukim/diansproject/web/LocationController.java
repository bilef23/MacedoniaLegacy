package mk.finki.ukim.diansproject.web;

import mk.finki.ukim.diansproject.model.Coordinates;
import mk.finki.ukim.diansproject.model.CulturalPlace;
import mk.finki.ukim.diansproject.service.CulturalPlaceService;
import mk.finki.ukim.diansproject.service.GeocodingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/loc")
@CrossOrigin(origins = "http://localhost:9090")
public class LocationController {
    private final CulturalPlaceService culturalPlaceService;
    private final GeocodingService geocodingService;

    public LocationController(CulturalPlaceService culturalPlaceService, GeocodingService geocodingService) {
        this.culturalPlaceService = culturalPlaceService;
        this.geocodingService = geocodingService;
    }
    @PostMapping("/receiveLoc")
    @ResponseBody
    public String receiveLocation(@RequestParam String latitude,
                                  @RequestParam String longitude,
                                  @RequestParam Long placeId) throws IOException {
        CulturalPlace place=culturalPlaceService.findById(placeId);
        String c=geocodingService.getCoordinates(place);
        System.out.println(c);
        return c;
    }
}
