package mk.finki.ukim.diansproject.service.impl;

import mk.finki.ukim.diansproject.model.CulturalPlace;
import mk.finki.ukim.diansproject.service.GeocodingService;
import mk.finki.ukim.diansproject.model.Coordinates;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@Service
public class GeocodingServiceImpl implements GeocodingService {

    @Override
    public Coordinates getCoordinates(CulturalPlace place) throws IOException {

            String fullName=place.getName();
            String city=place.getLocation();
            String addr = fullName+" "+city+" "+"North Macedonia"; // Replace with your address or place name
            String encodedPlaceName = URLEncoder.encode(addr, StandardCharsets.UTF_8.toString());
        System.out.println(addr);
            // Construct the URL for the Nominatim API

            String apiUrl = "https://nominatim.openstreetmap.org/search?format=json&q=" + encodedPlaceName + "&accept-language=en";

            URL url = new URL(apiUrl);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Read the response from the API
            Scanner scanner = new Scanner(connection.getInputStream());
            StringBuilder response = new StringBuilder();
            while (scanner.hasNextLine()) {
                response.append(scanner.nextLine());
            }
            scanner.close();

            // Parse the JSON response
            JSONArray results = new JSONArray(response.toString());

            if (results.length() > 0) {
                // Extract the first result (you may want to handle multiple results differently)
                JSONObject firstResult = results.getJSONObject(0);

                // Extract the latitude and longitude
                double latitude = firstResult.getDouble("lat");
                double longitude = firstResult.getDouble("lon");

                // Print the coordinates
                System.out.println("Latitude: " + latitude);
                System.out.println("Longitude: " + longitude);
                return new Coordinates(longitude,latitude);
            } else {
                System.out.println("No results found for the given address.");
            }
            return new Coordinates();
    }

}
