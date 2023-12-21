package mk.finki.ukim.diansproject.service.impl;

import mk.finki.ukim.diansproject.model.CulturalPlace;
import mk.finki.ukim.diansproject.repository.CoordinatesRepository;
import mk.finki.ukim.diansproject.service.CoordinatesService;
import mk.finki.ukim.diansproject.model.Coordinates;
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
