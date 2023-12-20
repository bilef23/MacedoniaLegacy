package mk.finki.ukim.diansproject.service;

import mk.finki.ukim.diansproject.model.CulturalPlace;

import java.io.IOException;

public interface GeocodingService {
    String getCoordinates(CulturalPlace place) throws IOException;
}
