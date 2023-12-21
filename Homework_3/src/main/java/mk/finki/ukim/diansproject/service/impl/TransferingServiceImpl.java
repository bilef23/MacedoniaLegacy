package mk.finki.ukim.diansproject.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import mk.finki.ukim.diansproject.model.Coordinates;
import mk.finki.ukim.diansproject.model.CulturalPlace;
import mk.finki.ukim.diansproject.repository.CoordinatesRepository;
import mk.finki.ukim.diansproject.repository.CulturalPlaceRepository;
import mk.finki.ukim.diansproject.service.TransferingService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransferingServiceImpl implements TransferingService {
    private final CulturalPlaceRepository culturalPlaceRepository;
    private final CoordinatesRepository coordinatesRepository;


    public TransferingServiceImpl(CulturalPlaceRepository culturalPlaceRepository, CoordinatesRepository coordinatesRepository) {
        this.culturalPlaceRepository = culturalPlaceRepository;
        this.coordinatesRepository = coordinatesRepository;
    }

    @Override
    public void processAndSave(String csvFilePath) throws CsvValidationException, IOException {
        List<CulturalPlace> list=readFromCsv(csvFilePath);
        culturalPlaceRepository.saveAll(list);
    }

    @Override
    public void readCoordinatesFromJSON(String jsonPath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode geoJsonNode = objectMapper.readTree(new File(jsonPath));
        JsonNode features = geoJsonNode.path("features");

        List<Coordinates> list=new ArrayList<>();
        for (JsonNode feature : features) {
            // Extract properties
            JsonNode properties = feature.path("properties");
            JsonNode geometry = feature.path("geometry");
            JsonNode coordinates = geometry.path("coordinates");
            double latitude,longitude;
            if(coordinates.get(0).asText().isEmpty()){
                latitude = coordinates.get(0).get(0).get(1).asDouble();
                longitude = coordinates.get(0).get(0).get(0).asDouble();
            }else{
                latitude = coordinates.get(1).asDouble();
                longitude = coordinates.get(0).asDouble();
            }

            String name =feature.path("properties").path("name").asText();
            List<CulturalPlace> p=culturalPlaceRepository.findCulturalPlaceByNameEquals(name);
            CulturalPlace place;


            if(p.size()>1){
                place=p.remove(0);
                deleteDuplicatePlaces(p);
            }else if(p.size()==1){
                place=p.get(0);
                if(coordinatesRepository.findByPlace(place)==null) {
                    coordinatesRepository.save(new Coordinates(latitude, longitude, place));
                }

            }
            if(!p.isEmpty()){


            }

        }
    }

    private void deleteDuplicatePlaces(List<CulturalPlace> list){
        list.stream().forEach(p->culturalPlaceRepository.delete(p));
    }

    private List<CulturalPlace> readFromCsv(String csvFilePath) throws IOException, CsvValidationException {
        List<CulturalPlace> list=new ArrayList<>();
        CSVReader reader = new CSVReader(new FileReader(csvFilePath));
        reader.readNext();
        String []entry;
        while((entry=reader.readNext())!=null){
            if(!entry[3].isEmpty()) {
                System.out.println(entry[1]);
                if(entry[1].equals("археолошки наоѓалишта")){
                    entry[1]="Archeological place";
                }
                if(entry[1].equals("place_of_worship")){
                    entry[1]="Place of worship";
                }
                list.add(new CulturalPlace(entry[0], entry[1], entry[2], entry[3]));
            }
        }
        return list;
    }
}
