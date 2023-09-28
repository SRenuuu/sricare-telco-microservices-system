package com.example.telcosystemservice.Controllers;

import com.example.telcosystemservice.dto.RegisterUserRequest;
import com.example.telcosystemservice.models.User;
import com.example.telcosystemservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/add")
    public User addUser(@RequestBody RegisterUserRequest registerUserRequest) {
        User newUser = User.builder()
                .nic(registerUserRequest.getNic())
                .fullName(registerUserRequest.getFullName())
                .email(registerUserRequest.getEmail())
                .dob(registerUserRequest.getDob())
                .build();
        return userRepository.save(newUser);
    }
}
