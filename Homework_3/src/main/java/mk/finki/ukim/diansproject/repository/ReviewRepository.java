package mk.finki.ukim.diansproject.repository;

import mk.finki.ukim.diansproject.model.UserReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReviewRepository extends JpaRepository<UserReview, Long> {

    List<UserReview> findByCulturalPlace_Id(Long id);
}
