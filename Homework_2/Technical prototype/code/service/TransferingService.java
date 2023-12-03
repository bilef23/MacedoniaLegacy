package mk.finki.ukim.diansproject.service;

import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;

public interface TransferingService {
    void processAndSave(String csvPath) throws CsvValidationException, IOException;
}
