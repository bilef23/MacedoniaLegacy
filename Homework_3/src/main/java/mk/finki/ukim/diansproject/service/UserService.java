package mk.finki.ukim.diansproject.service;

import mk.finki.ukim.diansproject.model.CulturalPlace;
import mk.finki.ukim.diansproject.model.User;

import java.util.List;

public interface UserService {
    boolean isAuthenticated(String user,String password);
    void addUser(String name,String username,String email,String password);
}
