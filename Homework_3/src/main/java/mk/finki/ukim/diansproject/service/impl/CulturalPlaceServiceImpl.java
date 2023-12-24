package mk.finki.ukim.diansproject.service.impl;

import mk.finki.ukim.diansproject.PipeAndFilter.Pipeline;
import mk.finki.ukim.diansproject.PipeAndFilter.filterImpl.CategoryFilter;
import mk.finki.ukim.diansproject.PipeAndFilter.filterImpl.SearchByLocation;
import mk.finki.ukim.diansproject.PipeAndFilter.filterImpl.SearchByName;
import mk.finki.ukim.diansproject.model.CulturalPlace;
import mk.finki.ukim.diansproject.repository.CulturalPlaceRepository;
import mk.finki.ukim.diansproject.service.CulturalPlaceService;
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
        List<CulturalPlace> all=culturalPlaceRepository.findAll();
        List<CulturalPlace>filtered=new ArrayList<>();
        if(searchName.isEmpty()&& searchLocation.isEmpty()&& category!=null){
            filtered=culturalPlaceRepository.findCulturalPlacesByCategory(category);
        }
        if(!searchName.isEmpty()&& searchLocation.isEmpty()&& !category.isEmpty()){
            filtered=culturalPlaceRepository.findCulturalPlacesByCategoryAndNameLike(category,searchName);
        }
        if(searchName.isEmpty()&& !searchLocation.isEmpty()&& !category.isEmpty()){
            filtered=culturalPlaceRepository.findCulturalPlacesByCategoryAndLocation(category,searchLocation);
        }
        if(!searchName.isEmpty()&& !searchLocation.isEmpty()&& !category.isEmpty()){
            filtered=culturalPlaceRepository.findCulturalPlacesByCategoryAndLocationAndNameLike(category,searchLocation,searchName);
        }
        if(!searchName.isEmpty()&& searchLocation.isEmpty()&& category.isEmpty()){
            filtered=culturalPlaceRepository.findCulturalPlacesByNameLike(searchName);
        }
        if(!searchName.isEmpty()&& !searchLocation.isEmpty()&& category.isEmpty()){
            filtered=culturalPlaceRepository.findCulturalPlacesByLocationAndNameLike(searchLocation,searchName);
        }
        if(searchName.isEmpty()&& !searchLocation.isEmpty()&& category.isEmpty()){
            filtered=culturalPlaceRepository.findCulturalPlacesByLocation(searchLocation);
        }

        return filtered;
    }

    @Override
    public CulturalPlace findById(Long id) {
        return culturalPlaceRepository.findById(id).get();
    }

    @Override
    public CulturalPlace findCulturalPlaceByName(String name) {
        return findCulturalPlaceByName(name);
    }

    @Override
    public void deleteObject(CulturalPlace p) {
            culturalPlaceRepository.delete(p);

    }

    @Override
    public void addObject(CulturalPlace p) {
        culturalPlaceRepository.save(p);
    }


}
