package mk.finki.ukim.diansproject.cultural_place_microservice.service;

import mk.finki.ukim.diansproject.cultural_place_microservice.model.Role;
import mk.finki.ukim.diansproject.cultural_place_microservice.model.User;


import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User register(String username, String password, String repeatPassword, String name, String email, Role role);

}
