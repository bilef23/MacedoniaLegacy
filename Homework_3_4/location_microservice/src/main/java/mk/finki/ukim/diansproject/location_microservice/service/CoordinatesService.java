package mk.finki.ukim.diansproject.location_microservice.service;


import mk.finki.ukim.diansproject.location_microservice.model.Coordinates;
import mk.finki.ukim.diansproject.location_microservice.model.CulturalPlace;

public interface CoordinatesService {
    Coordinates findByPlace(CulturalPlace place);
    void add(Coordinates cords);

}
