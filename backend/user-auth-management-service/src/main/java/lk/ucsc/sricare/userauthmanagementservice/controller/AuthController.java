package lk.ucsc.sricare.userauthmanagementservice.controller;

import jakarta.validation.Valid;
import lk.ucsc.sricare.userauthmanagementservice.dto.EmailPasswordLoginRequest;
import lk.ucsc.sricare.userauthmanagementservice.dto.JwtAuthenticationResponse;
import lk.ucsc.sricare.userauthmanagementservice.dto.RegistrationRequest;
import lk.ucsc.sricare.userauthmanagementservice.service.impl.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthServiceImpl authService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid RegistrationRequest request) {
        authService.registerUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }

    @PostMapping("/login")
    public JwtAuthenticationResponse loginUserByEmailAndPassword(@RequestBody @Valid EmailPasswordLoginRequest request) {
        return authService.loginUserByEmailAndPassword(request);
//        return ResponseEntity.status(HttpStatus.OK).body("User logged in successfully");
    }
}
