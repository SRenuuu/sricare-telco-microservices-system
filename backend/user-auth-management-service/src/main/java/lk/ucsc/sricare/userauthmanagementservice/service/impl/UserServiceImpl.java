package lk.ucsc.sricare.userauthmanagementservice.service.impl;

import lk.ucsc.sricare.userauthmanagementservice.model.User;
import lk.ucsc.sricare.userauthmanagementservice.repository.UserRepository;
import lk.ucsc.sricare.userauthmanagementservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserDetailsService userDetailsService() {
        return username -> userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

//    public User getUserByPhone(String phone) {
//        return userRepository.findByPhone(phone);
//    }
}
