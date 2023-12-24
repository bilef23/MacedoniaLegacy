package mk.finki.ukim.diansproject.repository;

import mk.finki.ukim.diansproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User searchUserByUsernameAndPassword (String username,String password);
    User searchUserByEmailAndPassword(String email,String password);
    Optional< User> findUserByUsername(String username);
}
