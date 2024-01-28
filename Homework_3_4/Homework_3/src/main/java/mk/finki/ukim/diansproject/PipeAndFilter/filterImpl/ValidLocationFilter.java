package mk.finki.ukim.diansproject.PipeAndFilter.filterImpl;

import mk.finki.ukim.diansproject.PipeAndFilter.Filter;
import mk.finki.ukim.diansproject.model.CulturalPlace;

import java.util.List;
import java.util.stream.Collectors;

public class ValidLocationFilter implements Filter<List<CulturalPlace>,List<CulturalPlace>> {
    @Override
    public List<CulturalPlace> execute(List<CulturalPlace> input) {
        return input.stream().parallel().filter(object->!(object.getLocation()==null)).collect(Collectors.toList());
    }
}
