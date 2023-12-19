package mk.finki.ukim.diansproject.service;

import mk.finki.ukim.diansproject.model.CulturalPlace;
import mk.finki.ukim.diansproject.model.Coordinates;

import java.io.IOException;

public interface GeocodingService {
    Coordinates getCoordinates(CulturalPlace place) throws IOException;
}
