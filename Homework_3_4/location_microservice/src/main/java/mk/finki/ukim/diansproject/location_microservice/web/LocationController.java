package mk.finki.ukim.diansproject.location_microservice.web;

import mk.finki.ukim.diansproject.location_microservice.model.Coordinates;
import mk.finki.ukim.diansproject.location_microservice.model.CulturalPlace;

import mk.finki.ukim.diansproject.location_microservice.service.CoordinatesService;
import mk.finki.ukim.diansproject.location_microservice.service.CulturalPlaceService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin("*")
@RequestMapping("/location")
@RestController
public class LocationController {
    private final CulturalPlaceService culturalPlaceService;
    private final CoordinatesService coordinatesService;

    public LocationController(CulturalPlaceService culturalPlaceService, CoordinatesService coordinatesService) {
        this.culturalPlaceService = culturalPlaceService;
        this.coordinatesService = coordinatesService;
    }


    @GetMapping()
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
