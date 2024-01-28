package mk.finki.ukim.diansproject.web;

import mk.finki.ukim.diansproject.model.CulturalPlace;
import mk.finki.ukim.diansproject.service.CulturalPlaceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/new-place")
public class NewPlaceController {
    private final CulturalPlaceService culturalPlaceService;

    public NewPlaceController(CulturalPlaceService culturalPlaceService) {
        this.culturalPlaceService = culturalPlaceService;
    }

    @GetMapping()
    public String showNewPlaceForm() {
        return "new_place_form.html";
    }

    @PostMapping("/save")
    public String saveNewPlace(@RequestParam String name, @RequestParam String category, @RequestParam String location) {
        CulturalPlace newPlace = new CulturalPlace(name, category, location);
        culturalPlaceService.addObject(newPlace);
        return "redirect:/places";
    }
}
