package lk.ucsc.sricare.userauthmanagementservice.service;

import lk.ucsc.sricare.userauthmanagementservice.dto.RegistrationRequest;
import lk.ucsc.sricare.userauthmanagementservice.exception.CustomException;
import lk.ucsc.sricare.userauthmanagementservice.model.User;
import lk.ucsc.sricare.userauthmanagementservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

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
                .build();

        // Encrypt the password before saving it
        String encodedPassword = passwordEncoder.encode(registrationRequest.getPassword());
        user.setPassword(encodedPassword);

        // Save the user to the database
        userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

//    public User getUserByPhone(String phone) {
//        return userRepository.findByPhone(phone);
//    }
}
