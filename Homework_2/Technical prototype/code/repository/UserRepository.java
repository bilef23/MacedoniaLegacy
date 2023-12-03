package mk.finki.ukim.diansproject.repository;

import mk.finki.ukim.diansproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User searchUserByUsernameAndPassword (String username,String password);
    User searchUserByEmailAndPassword(String email,String password);
}
