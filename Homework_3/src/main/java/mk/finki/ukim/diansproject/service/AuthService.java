package mk.finki.ukim.diansproject.service;

import mk.finki.ukim.diansproject.model.User;

import java.util.List;

public interface AuthService {
    User login(String username, String password);

    List<User> findAll();

}
