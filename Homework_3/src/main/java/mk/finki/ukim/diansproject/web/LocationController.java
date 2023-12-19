package mk.finki.ukim.diansproject.web;

import mk.finki.ukim.diansproject.model.Coordinates;
import mk.finki.ukim.diansproject.model.CulturalPlace;
import mk.finki.ukim.diansproject.service.CulturalPlaceService;
import mk.finki.ukim.diansproject.service.GeocodingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequestMapping("/loc")
public class LocationController {
    private final CulturalPlaceService culturalPlaceService;
    private final GeocodingService geocodingService;

    public LocationController(CulturalPlaceService culturalPlaceService, GeocodingService geocodingService) {
        this.culturalPlaceService = culturalPlaceService;
        this.geocodingService = geocodingService;
    }
    @PostMapping("/receiveLoc")
    public String receiveLocation(@RequestParam String latitude,
                                  @RequestParam String longitude,
                                  @RequestParam String placeId) throws IOException {
        CulturalPlace place=culturalPlaceService.findById(Long.getLong(placeId));
        Coordinates c=geocodingService.getCoordinates(place);
        System.out.println(c.getLatitude()+" "+c.getLongitude());
        return "redirect:/places";
    }
}
