package mk.finki.ukim.diansproject.PipeAndFilter.filterImpl;

import mk.finki.ukim.diansproject.PipeAndFilter.Filter;
import mk.finki.ukim.diansproject.model.CulturalPlace;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class SearchByLocation implements Filter<List<CulturalPlace>, List<CulturalPlace>> {
    String location;

    public SearchByLocation(String location) {
        this.location=location;
    }

    @Override
    public List<CulturalPlace> execute(List<CulturalPlace> input) throws IOException {
        return input.stream().parallel().filter(culturalPlace -> culturalPlace.getLocation().equals(location)).collect(Collectors.toList());
    }
}
