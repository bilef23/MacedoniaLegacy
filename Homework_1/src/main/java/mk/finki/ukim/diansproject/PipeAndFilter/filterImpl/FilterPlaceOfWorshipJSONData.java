package mk.finki.ukim.diansproject.PipeAndFilter.filterImpl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import mk.finki.ukim.diansproject.PipeAndFilter.Filter;
import mk.finki.ukim.diansproject.model.CulturalPlace;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilterPlaceOfWorshipJSONData implements Filter<String,List<CulturalPlace>> {
    private final String filePath;
    public FilterPlaceOfWorshipJSONData(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<CulturalPlace> execute(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode geoJsonNode = objectMapper.readTree(new File(filePath));
        JsonNode features = geoJsonNode.path("features");

        List<CulturalPlace> list=new ArrayList<>();

        for (JsonNode feature : features) {
            // Extract properties
            JsonNode properties = feature.path("properties");
            JsonNode geometry = feature.path("geometry");
            JsonNode coordinates = geometry.path("coordinates");
            list.add(new CulturalPlace(properties.path("name").asText(),properties.path("amenity").asText(),coordinates.toString()));
        }

        return list;


    }
}
