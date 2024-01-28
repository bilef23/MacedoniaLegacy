package mk.finki.ukim.diansproject.PipeAndFilter.filterImpl;

import mk.finki.ukim.diansproject.PipeAndFilter.Filter;
import mk.finki.ukim.diansproject.model.CulturalPlace;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class SearchByName implements Filter<List<CulturalPlace>, List<CulturalPlace>> {
    String name;

    public SearchByName(String name) {
        this.name=name;
    }

    @Override
    public List<CulturalPlace> execute(List<CulturalPlace> input) throws IOException {
        return input.stream().parallel().filter(culturalPlace -> culturalPlace.getName().contains(name)).collect(Collectors.toList());
    }
}
