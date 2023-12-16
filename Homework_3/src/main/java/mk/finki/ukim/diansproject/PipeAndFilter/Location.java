package mk.finki.ukim.diansproject.PipeAndFilter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Location {
    public static String getVillage(String coordinates)throws IOException, InterruptedException {
        String[] crd=coordinates.split(",");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://nominatim.openstreetmap.org/reverse?format=json&lat="+crd[1].trim()+"&lon="+crd[0].trim()+"&accept-language=en"))
                .header("User-Agent", "Java HttpClient")
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(response.body());
        String village = jsonNode.path("address").path("village").asText();
        if(village.isEmpty()){
            village=jsonNode.path("address").path("city").asText();
        }
        return village;
// Extract information from the JSON response
    }
}
