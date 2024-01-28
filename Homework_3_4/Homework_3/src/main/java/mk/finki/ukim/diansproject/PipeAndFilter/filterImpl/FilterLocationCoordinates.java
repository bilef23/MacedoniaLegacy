package mk.finki.ukim.diansproject.PipeAndFilter.filterImpl;

import mk.finki.ukim.diansproject.PipeAndFilter.Filter;
import mk.finki.ukim.diansproject.PipeAndFilter.Location;
import mk.finki.ukim.diansproject.model.CulturalPlace;

import java.io.IOException;
import java.util.List;

public class FilterLocationCoordinates implements Filter<List<CulturalPlace>, List<CulturalPlace>> {
    @Override
    public List<CulturalPlace> execute(List<CulturalPlace> input)throws IOException,InterruptedException {
        input.stream().parallel().forEach(culturalPlace -> {
            String loc=null;
            try {
                loc = Location.getVillage(culturalPlace.getLocation());
                System.out.println(loc);
            } catch (IOException | InterruptedException e) {
                System.out.println("Exception");
            }

            culturalPlace.setLocation(loc);
        });
        return input;
    }
}
