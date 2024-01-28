package mk.finki.ukim.diansproject.location_microservice.repository;


import mk.finki.ukim.diansproject.location_microservice.model.Coordinates;
import mk.finki.ukim.diansproject.location_microservice.model.CulturalPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordinatesRepository extends JpaRepository<Coordinates,Long> {
    Coordinates findByPlace(CulturalPlace place);
}
