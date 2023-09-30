package com.example.telcosystemservice.services;

import com.example.telcosystemservice.dto.AnyResponse;
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

    public AnyResponse saveUser(User user) {
        try {
            User newUser = userRepository.save(user);
            return AnyResponse.builder().message("User added successfully").data(newUser).build();
        } catch (Exception e) {
            return AnyResponse.builder().message("Could not add user").data(null).build();
        }
    }
}
