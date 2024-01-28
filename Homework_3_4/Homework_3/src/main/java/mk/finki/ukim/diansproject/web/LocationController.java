package mk.finki.ukim.diansproject.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
@RequestMapping("/loc")
@CrossOrigin(origins = "http://localhost:9090")
public class LocationController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/receiveLoc")
    @ResponseBody
    public String receiveLocation(@RequestParam Long placeId) throws IOException {
        String str = restTemplate.getForObject("https://location-service-azi3.onrender.com/location?placeId=" + placeId,String.class);
        return str;
    }
}
