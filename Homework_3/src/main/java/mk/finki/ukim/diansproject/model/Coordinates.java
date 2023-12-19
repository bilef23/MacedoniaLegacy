package mk.finki.ukim.diansproject.model;

import lombok.Data;

@Data
public class Coordinates {
    Double latitude;
    Double longitude;

    public Coordinates(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Coordinates() {
    }
}
