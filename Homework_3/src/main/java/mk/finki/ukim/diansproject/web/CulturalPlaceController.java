package mk.finki.ukim.diansproject.web;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import mk.finki.ukim.diansproject.PipeAndFilter.Pipeline;
import mk.finki.ukim.diansproject.PipeAndFilter.filterImpl.*;
import mk.finki.ukim.diansproject.model.CulturalPlace;
import mk.finki.ukim.diansproject.service.CulturalPlaceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CulturalPlaceController {
    private final CulturalPlaceService culturalPlaceService;

    public CulturalPlaceController(CulturalPlaceService culturalPlaceService) {
        this.culturalPlaceService = culturalPlaceService;
    }

    @GetMapping("/places")
    public String getMainPage(Model model) throws IOException, CsvException {
        model.addAttribute("places",culturalPlaceService.findAll());
        return "index.html";
    }

    @GetMapping("/listPlaces")
    public String filterPlaces( String category,  String searchName, String searchLocation, Model model) throws IOException, InterruptedException {
            List<CulturalPlace> filtered=culturalPlaceService.filter(searchName,category,searchLocation);
            model.addAttribute("places",filtered);
            return "index.html";
    }


}
