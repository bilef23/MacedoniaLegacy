package mk.finki.ukim.diansproject.web;

import com.opencsv.exceptions.CsvValidationException;
import mk.finki.ukim.diansproject.service.TransferingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Controller
public class TriggerController {

    private final TransferingService transferingService;

    public TriggerController(TransferingService transferingService) {
        this.transferingService = transferingService;
    }

    @GetMapping("/trigger")
    public void triggerProcess() throws CsvValidationException, IOException {
        transferingService.processAndSave("src/main/java/mk/finki/ukim/diansproject/PipeAndFilter/Files/final.csv");
    }
}
