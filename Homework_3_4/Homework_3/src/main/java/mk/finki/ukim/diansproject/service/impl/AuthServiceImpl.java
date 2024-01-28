package mk.finki.ukim.diansproject.service.impl;

import mk.finki.ukim.diansproject.model.Exceptions.InvalidArgumentsException;
import mk.finki.ukim.diansproject.model.Exceptions.InvalidUserCredentialsException;
import mk.finki.ukim.diansproject.model.User;
import mk.finki.ukim.diansproject.repository.UserRepository;
import mk.finki.ukim.diansproject.service.AuthService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }

        return userRepository.findByUsernameAndPassword(username, password)
                .orElseThrow(InvalidUserCredentialsException::new);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

}

