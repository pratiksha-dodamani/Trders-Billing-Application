package com.example.billing.service;

import com.example.billing.model.User;
import com.example.billing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByEmail(String email) {
        return userRepository.findByEmail(email); // Use the newly added method
    }
    // @Autowired
    // private UserRepository userRepository;
    @Autowired
private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        // Here you can add logic for checking if the user already exists, password hashing, etc.
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
