package mk.finki.ukim.diansproject.location_microservice.service;



import mk.finki.ukim.diansproject.location_microservice.model.CulturalPlace;

import java.io.IOException;
import java.util.List;

public interface CulturalPlaceService {
    List<CulturalPlace> findAll();
    List<CulturalPlace> filter(String name,String category,String location) throws IOException, InterruptedException;
    CulturalPlace findById(Long id);
    CulturalPlace findCulturalPlaceByName(String name);
}
