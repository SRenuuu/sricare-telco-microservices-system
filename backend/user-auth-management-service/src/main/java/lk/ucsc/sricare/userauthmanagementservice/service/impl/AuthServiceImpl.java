package lk.ucsc.sricare.userauthmanagementservice.service.impl;

import lk.ucsc.sricare.userauthmanagementservice.dto.EmailPasswordLoginRequest;
import lk.ucsc.sricare.userauthmanagementservice.dto.JwtAuthenticationResponse;
import lk.ucsc.sricare.userauthmanagementservice.dto.RegistrationRequest;
import lk.ucsc.sricare.userauthmanagementservice.exception.CustomException;
import lk.ucsc.sricare.userauthmanagementservice.model.Role;
import lk.ucsc.sricare.userauthmanagementservice.model.User;
import lk.ucsc.sricare.userauthmanagementservice.repository.UserRepository;
import lk.ucsc.sricare.userauthmanagementservice.service.AuthService;
import lk.ucsc.sricare.userauthmanagementservice.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public void registerUser(RegistrationRequest registrationRequest) {
        // Check if the NIC or email is already registered
        if (userRepository.existsByNic(registrationRequest.getNic())) {
            throw new CustomException("NIC is already registered", HttpStatus.CONFLICT);
        }

        if (userRepository.existsByEmail(registrationRequest.getEmail())) {
            throw new CustomException("Email is already registered", HttpStatus.CONFLICT);
        }

        // Create a new user entity
        User user = User.builder()
                .nic(registrationRequest.getNic())
                .name(registrationRequest.getName())
                .email(registrationRequest.getEmail())
                .role(Role.CUSTOMER)
                .build();

        // Encrypt the password before saving it
        String encodedPassword = passwordEncoder.encode(registrationRequest.getPassword());
        user.setPassword(encodedPassword);

        // Save the user to the database
        userRepository.save(user);
    }

    @Override
    public JwtAuthenticationResponse loginUserByEmailAndPassword(EmailPasswordLoginRequest request) {
        // Authenticate the user
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //return jwtGenVal.generateToken(authentication);


        String jwt = jwtService.generateToken(authentication);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

//    public void loginUserByPhoneAndOTP(PhoneOtpLoginRequest request) {
//        // Retrieve the user by phone
//        User user = userService.getUserByPhone(phone);
//
//        // Validate the user
//        if (user == null || !validateOTP(user, otp)) {
//            throw new RuntimeException("Invalid phone or OTP");
//        }
//
//        // Additional validation or actions as needed
//
//        // Successful login
//    }
}
