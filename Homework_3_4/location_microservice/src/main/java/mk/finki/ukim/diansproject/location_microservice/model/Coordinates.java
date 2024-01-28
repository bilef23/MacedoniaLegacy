package mk.finki.ukim.diansproject.location_microservice.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Coordinates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Double latitude;
    Double longitude;
    @OneToOne
    CulturalPlace place;


    public Coordinates(Double latitude, Double longitude, CulturalPlace place) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.place=place;
    }

    public Coordinates() {
    }

}
