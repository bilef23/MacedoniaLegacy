package mk.finki.ukim.diansproject.PipeAndFilter.filterImpl;

import com.opencsv.CSVWriter;
import mk.finki.ukim.diansproject.PipeAndFilter.Filter;
import mk.finki.ukim.diansproject.model.CulturalPlace;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriterFilter implements Filter<List<CulturalPlace>, Void> {
    private final String filePath;

    public CsvWriterFilter(String filePath) {
        this.filePath = filePath;
    }


    @Override
    public Void execute(List<CulturalPlace> input) throws IOException {
        CSVWriter csvWriter = new CSVWriter(new FileWriter(filePath,true));
        for(CulturalPlace culturalPlace : input){
            String[] data = {
                    culturalPlace.getName(),
                    culturalPlace.getCategory(),
                    culturalPlace.getPhoneNumber(),
                    culturalPlace.getLocation()
            };
            csvWriter.writeNext(data);
        }
        csvWriter.close();
        return null;
    }
}
