package mk.finki.ukim.diansproject.cultural_place_microservice.service;



import mk.finki.ukim.diansproject.cultural_place_microservice.model.User;

import java.util.List;

public interface AuthService {
    User login(String username, String password);

    List<User> findAll();

}
