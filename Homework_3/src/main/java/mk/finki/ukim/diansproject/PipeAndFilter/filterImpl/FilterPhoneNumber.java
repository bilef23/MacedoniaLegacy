package mk.finki.ukim.diansproject.PipeAndFilter.filterImpl;

import mk.finki.ukim.diansproject.PipeAndFilter.Filter;
import mk.finki.ukim.diansproject.model.CulturalPlace;

import java.io.IOException;
import java.util.List;

public class FilterPhoneNumber implements Filter<List<CulturalPlace>,List<CulturalPlace>> {
    @Override
    public List<CulturalPlace> execute(List<CulturalPlace> input) throws IOException, InterruptedException {
        input.stream().parallel().forEach(place->{
            String ph=place.getPhoneNumber().replace("tel:"," ").trim();
            place.setPhoneNumber(ph);
        });
        return input;
    }
}
