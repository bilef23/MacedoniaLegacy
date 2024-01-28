package mk.finki.ukim.diansproject.PipeAndFilter.filterImpl;

import mk.finki.ukim.diansproject.PipeAndFilter.Filter;
import mk.finki.ukim.diansproject.model.CulturalPlace;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FilterLocationPlaceWorship implements Filter<List<CulturalPlace>,List<CulturalPlace>> {
    @Override
    public List<CulturalPlace> execute(List<CulturalPlace> input) throws IOException {
        input.stream().forEach(place->{
            String location=place.getLocation();
            String []temp=location.replace('[',' ').replace(']',' ').trim().split(",\\s+");
            place.setLocation(temp[0].trim());
        });

        return input;
    }
}
