package mk.finki.ukim.diansproject.PipeAndFilter;
import com.opencsv.CSVWriter;
import mk.finki.ukim.diansproject.PipeAndFilter.filterImpl.*;
import mk.finki.ukim.diansproject.model.CulturalPlace;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        //file paths
        String filePathJson="src/main/java/mk/finki/ukim/diansproject/PipeAndFilter/Files/export.geojson";
        String csvFilePath="src/main/java/mk/finki/ukim/diansproject/PipeAndFilter/Files/final.csv";
        //Scraped data
        Elements archeological=WebScraperArcheologicalPlace.scrapeElements();
        Elements museum=WebScraperMuseum.scrapeElements();

        //Initializing new csv file
        CSVWriter csvWriter = new CSVWriter(new FileWriter(csvFilePath));
        String[] headers = {"Name", "Category", "Location", "Phone Number"};
        csvWriter.writeNext(headers);
        csvWriter.close();

        //Pipeline for place of worship
        Pipeline<String, Void> pipeline1 = new Pipeline<>(new FilterPlaceOfWorshipJSONData(filePathJson))
                .chain(new FilterValidName())
                .chain(new FilterLocationPlaceWorship())
                .chain(new FilterLocationCoordinates())
                .chain(new ValidLocationFilter())
                .chain(new CsvWriterFilter(csvFilePath));



        // Pipeline for archeological places
        pipeline1.process(filePathJson);

        Pipeline<Elements,Void> pipeline2 = new Pipeline<>(new extractDataArcheologicalPlace(archeological))
                .chain(new FilterPhoneNumber())
                .chain(new CsvWriterFilter(csvFilePath));
        pipeline2.process(archeological);

        // Pipeline for museums
        Pipeline<Elements, Void> pipeline3 = new Pipeline<>(new extractDataArcheologicalPlace(museum))
                .chain(new ChangeMuseumCategory())
                .chain(new FilterPhoneNumber())
                .chain(new CsvWriterFilter(csvFilePath));
        pipeline3.process(museum);
    }


}

