package com.example.telcosystemservice.services;

import com.example.telcosystemservice.models.User;
import com.example.telcosystemservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(String nic, String fullName, Date dob, String email) {
        User user = new User(nic, fullName, dob, email);

        return userRepository.save(user);
    }
}
