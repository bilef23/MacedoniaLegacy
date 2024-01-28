package mk.finki.ukim.diansproject.PipeAndFilter.filterImpl;

import mk.finki.ukim.diansproject.PipeAndFilter.Filter;
import mk.finki.ukim.diansproject.model.CulturalPlace;

import java.io.IOException;
import java.util.List;

public class ChangeMuseumCategory implements Filter<List<CulturalPlace>,List<CulturalPlace>> {
    @Override
    public List<CulturalPlace> execute(List<CulturalPlace> input) throws IOException {
       input.stream().parallel().forEach(culturalPlace -> culturalPlace.setCategory("museum"));
       return input;
    }
}
