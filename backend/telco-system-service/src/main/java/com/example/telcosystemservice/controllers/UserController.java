package com.example.telcosystemservice.controllers;

import com.example.telcosystemservice.dto.AnyResponse;
import com.example.telcosystemservice.dto.RegisterUserRequest;
import com.example.telcosystemservice.models.User;
import com.example.telcosystemservice.repositories.UserRepository;
import com.example.telcosystemservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public AnyResponse addUser(@RequestBody RegisterUserRequest registerUserRequest) {
        User newUser = User.builder()
                .nic(registerUserRequest.getNic())
                .fullName(registerUserRequest.getFullName())
                .email(registerUserRequest.getEmail())
                .dob(registerUserRequest.getDob())
                .build();
        return userService.saveUser(newUser);
    }
}
