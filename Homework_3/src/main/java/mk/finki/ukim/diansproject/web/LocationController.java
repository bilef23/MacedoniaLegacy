package mk.finki.ukim.diansproject.web;

import mk.finki.ukim.diansproject.model.Coordinates;
import mk.finki.ukim.diansproject.model.CulturalPlace;
import mk.finki.ukim.diansproject.service.CoordinatesService;
import mk.finki.ukim.diansproject.service.CulturalPlaceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/loc")
@CrossOrigin(origins = "http://localhost:9090")
public class LocationController {
    private final CulturalPlaceService culturalPlaceService;
    private final CoordinatesService coordinatesService;

    public LocationController(CulturalPlaceService culturalPlaceService, CoordinatesService coordinatesService) {
        this.culturalPlaceService = culturalPlaceService;
        this.coordinatesService = coordinatesService;
    }
    @PostMapping("/receiveLoc")
    @ResponseBody
    public String receiveLocation(@RequestParam Long placeId) throws IOException {
        CulturalPlace place=culturalPlaceService.findById(placeId);
        Coordinates c=coordinatesService.findByPlace(place);
        double lat=c.getLatitude();
        double lon=c.getLongitude();
        System.out.println(lat);
        System.out.println(lon);
        return "{\"latitude\": "+lat+", \"longitude\": "+lon+" }";
    }
}
