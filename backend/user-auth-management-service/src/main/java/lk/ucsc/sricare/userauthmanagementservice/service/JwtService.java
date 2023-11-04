package lk.ucsc.sricare.userauthmanagementservice.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String extractUserName(String token);

    String generateToken(Authentication authentication);

    boolean isTokenValid(String token, UserDetails userDetails);
}
