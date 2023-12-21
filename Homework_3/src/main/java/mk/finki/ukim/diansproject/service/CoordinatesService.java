package mk.finki.ukim.diansproject.service;

import mk.finki.ukim.diansproject.model.CulturalPlace;
import mk.finki.ukim.diansproject.model.Coordinates;

public interface CoordinatesService {
    Coordinates findByPlace(CulturalPlace place);
    void add(Coordinates cords);

}
