package mk.finki.ukim.diansproject.service.impl;

import mk.finki.ukim.diansproject.model.User;
import mk.finki.ukim.diansproject.repository.UserRepository;
import mk.finki.ukim.diansproject.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    private boolean searchUserByUsernameAndPassword(String username, String password) {

        return userRepository.searchUserByUsernameAndPassword(username,password)!=null;
    }


    private boolean searchUserByEmailAndPassword(String email, String password) {
        return userRepository.searchUserByEmailAndPassword(email,password)!=null;
    }

    @Override
    public boolean isAuthenticated(String user, String password) {
        return searchUserByEmailAndPassword(user,password)||searchUserByUsernameAndPassword(user,password);
    }

    @Override
    public void addUser(String name, String username, String email, String password) {
        if(!name.isEmpty() && !username.isEmpty() && !email.isEmpty() && !password.isEmpty()){
            userRepository.save(new User(name,username,password,email));
        }
    }
}
