package mk.finki.ukim.diansproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CulturalPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String category;
    private String phoneNumber;
    private String location;

    public CulturalPlace(String name, String category, String phoneNumber, String location) {
        this.name = name;
        this.category = category;
        this.phoneNumber = phoneNumber;
        this.location = location;
    }

    public CulturalPlace() {
    }

    public CulturalPlace(String name, String category, String location) {
        this.name = name;
        this.category = category;
        this.location = location;
        this.phoneNumber="";
    }


}
