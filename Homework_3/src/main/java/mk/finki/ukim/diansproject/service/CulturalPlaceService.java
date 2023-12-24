package mk.finki.ukim.diansproject.service;

import mk.finki.ukim.diansproject.model.CulturalPlace;
import mk.finki.ukim.diansproject.model.UserReview;

import java.io.IOException;
import java.util.List;

public interface CulturalPlaceService {
    List<CulturalPlace> findAll();
    List<CulturalPlace> filter(String name,String category,String location) throws IOException, InterruptedException;
    CulturalPlace findById(Long id);
    CulturalPlace findCulturalPlaceByName(String name);

    void save(CulturalPlace newPlace);
}
