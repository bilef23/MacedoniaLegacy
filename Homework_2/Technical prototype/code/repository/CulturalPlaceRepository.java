package mk.finki.ukim.diansproject.repository;

import mk.finki.ukim.diansproject.model.CulturalPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CulturalPlaceRepository extends JpaRepository<CulturalPlace, Long> {
    List<CulturalPlace> findCulturalPlacesByLocation(String location);
    List<CulturalPlace> findCulturalPlacesByCategory(String category);
    List<CulturalPlace> findCulturalPlacesByNameLike(String name);
    List<CulturalPlace> findCulturalPlacesByCategoryAndNameLike(String category,String name);
    List<CulturalPlace> findCulturalPlacesByCategoryAndLocation(String category,String location);
    List<CulturalPlace> findCulturalPlacesByLocationAndNameLike(String location,String name);
    List<CulturalPlace> findCulturalPlacesByCategoryAndLocationAndNameLike(String category,String location,String name);
}
