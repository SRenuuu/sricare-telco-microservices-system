package lk.ucsc.sricare.userauthmanagementservice.service.impl;

import lk.ucsc.sricare.userauthmanagementservice.exception.CustomException;
import lk.ucsc.sricare.userauthmanagementservice.model.Role;
import lk.ucsc.sricare.userauthmanagementservice.model.User;
import lk.ucsc.sricare.userauthmanagementservice.repository.UserRepository;
import lk.ucsc.sricare.userauthmanagementservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Role role) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        // Add "ROLE_USER" authority for all roles
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        if (role != null) {
            if (role.equals(Role.STAFF)) {
                authorities.add(new SimpleGrantedAuthority("ROLE_STAFF"));
            } else if (role.equals(Role.CUSTOMER)) {
                authorities.add(new SimpleGrantedAuthority("ROLE_CUSTOMER"));
            }
        }

        return authorities;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new CustomException("Invalid email or password", HttpStatus.UNAUTHORIZED));

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRole()));
    }

//    public User getUserByPhone(String phone) {
//        return userRepository.findByPhone(phone);
//    }
}
