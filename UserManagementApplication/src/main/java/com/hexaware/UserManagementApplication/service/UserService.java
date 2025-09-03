package com.hexaware.UserManagementApplication.service;



import com.hexaware.UserManagementApplication.entity.*;
import com.hexaware.UserManagementApplication.exception.UserNotFoundException;
import com.hexaware.UserManagementApplication.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String login(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password)
                .orElseThrow(() -> new UserNotFoundException("Invalid username or password!"));

        return "Logged in successfully";
    }

    public User register(User user) {
        return userRepository.save(user);
    }
}
