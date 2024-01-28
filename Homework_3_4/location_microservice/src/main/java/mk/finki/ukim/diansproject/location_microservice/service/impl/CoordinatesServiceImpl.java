package mk.finki.ukim.diansproject.location_microservice.service.impl;


import mk.finki.ukim.diansproject.location_microservice.model.Coordinates;
import mk.finki.ukim.diansproject.location_microservice.model.CulturalPlace;
import mk.finki.ukim.diansproject.location_microservice.repository.CoordinatesRepository;
import mk.finki.ukim.diansproject.location_microservice.service.CoordinatesService;
import org.springframework.stereotype.Service;

@Service
public class CoordinatesServiceImpl implements CoordinatesService {
    private final CoordinatesRepository coordinatesRepository;

    public CoordinatesServiceImpl(CoordinatesRepository coordinatesRepository) {
        this.coordinatesRepository = coordinatesRepository;
    }

    @Override
    public Coordinates findByPlace(CulturalPlace place) {
        return coordinatesRepository.findByPlace(place);
    }

    @Override
    public void add(Coordinates cords) {
        coordinatesRepository.save(cords);
    }
}
