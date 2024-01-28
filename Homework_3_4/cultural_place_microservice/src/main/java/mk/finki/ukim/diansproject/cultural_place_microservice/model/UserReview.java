package mk.finki.ukim.diansproject.cultural_place_microservice.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.finki.ukim.diansproject.cultural_place_microservice.model.CulturalPlace;

@Data
@NoArgsConstructor
@Entity
public class UserReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer rating;
    private String comment;
    @ManyToOne
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)

    private CulturalPlace culturalPlace;

    public UserReview(String comment, Integer rating, User user, CulturalPlace culturalPlace) {
        this.rating = rating;
        this.comment = comment;
        this.user = user;
        this.culturalPlace = culturalPlace;
    }
}

