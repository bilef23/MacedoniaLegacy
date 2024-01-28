package mk.finki.ukim.diansproject.cultural_place_microservice.service.impl;

import mk.finki.ukim.diansproject.cultural_place_microservice.model.CulturalPlace;
import mk.finki.ukim.diansproject.cultural_place_microservice.repository.CulturalPlaceRepository;

import mk.finki.ukim.diansproject.cultural_place_microservice.service.CulturalPlaceService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CulturalPlaceServiceImpl implements CulturalPlaceService {

    private final CulturalPlaceRepository culturalPlaceRepository;

    public CulturalPlaceServiceImpl(CulturalPlaceRepository culturalPlaceRepository) {
        this.culturalPlaceRepository = culturalPlaceRepository;
    }

    @Override
    public List<CulturalPlace> findAll() {
        return culturalPlaceRepository.findAll();
    }

    @Override
    public List<CulturalPlace> filter(String searchName, String category, String searchLocation) throws IOException, InterruptedException {
        if( category!=null){
            return culturalPlaceRepository.findCulturalPlacesByCategory(category);
        }
        return this.findAll();
    }

    @Override
    public CulturalPlace findById(Long id) {
        return culturalPlaceRepository.findById(id).get();
    }

    @Override
    public CulturalPlace findCulturalPlaceByName(String name) {
        return findCulturalPlaceByName(name);
    }

}
