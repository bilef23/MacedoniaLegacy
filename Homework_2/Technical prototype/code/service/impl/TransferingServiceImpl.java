package mk.finki.ukim.diansproject.service.impl;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import mk.finki.ukim.diansproject.model.CulturalPlace;
import mk.finki.ukim.diansproject.repository.CulturalPlaceRepository;
import mk.finki.ukim.diansproject.service.TransferingService;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransferingServiceImpl implements TransferingService {
    private final CulturalPlaceRepository culturalPlaceRepository;

    public TransferingServiceImpl(CulturalPlaceRepository culturalPlaceRepository) {
        this.culturalPlaceRepository = culturalPlaceRepository;
    }

    @Override
    public void processAndSave(String csvFilePath) throws CsvValidationException, IOException {
        List<CulturalPlace> list=readFromCsv(csvFilePath);
        culturalPlaceRepository.saveAll(list);
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
