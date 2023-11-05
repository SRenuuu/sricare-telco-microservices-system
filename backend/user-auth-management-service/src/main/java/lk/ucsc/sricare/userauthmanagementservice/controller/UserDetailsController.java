package lk.ucsc.sricare.userauthmanagementservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lk.ucsc.sricare.userauthmanagementservice.dto.UserDetailsDTO;
import lk.ucsc.sricare.userauthmanagementservice.model.Role;
import lk.ucsc.sricare.userauthmanagementservice.model.User;
import lk.ucsc.sricare.userauthmanagementservice.repository.UserRepository;

@RestController
@RequestMapping("/api/user-details")
@RequiredArgsConstructor
public class UserDetailsController {
    private final UserRepository userRepository;

    @GetMapping("/my")
    public ResponseEntity<?> getCurrentUserDetails() {
        // Get the currently authenticated user's details
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof org.springframework.security.core.userdetails.User) {
            org.springframework.security.core.userdetails.User userDetails = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
            String username = userDetails.getUsername();

            // Fetch user details from UserRepository based on the username (email)
            User user = userRepository.findByEmail(username).orElse(null);

            if (user != null) {
                // Convert the User entity to UserDetailsDTO
                UserDetailsDTO userDetailsDTO = convertUserToDTO(user);

                // Return the user details as JSON in a ResponseEntity
                return ResponseEntity.ok(userDetailsDTO);
            } else {
                // User not found
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found for username: " + username);
            }
        } else {
            // User not authenticated
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not authenticated");
        }
    }

    @GetMapping("/by-phone")
    public ResponseEntity<?> getUserByPhone(@RequestParam("phone") String phone) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (hasRole(authentication, Role.STAFF)) {
            // Logic to fetch user details by phone for ROLE_STAFF
            User user = userRepository.findByPhone(phone).orElse(null);

            if (user != null) {
                // Convert the User entity to UserDetailsDTO
                UserDetailsDTO userDetailsDTO = convertUserToDTO(user);

                return ResponseEntity.ok(userDetailsDTO);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found for phone: " + phone);
            }
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied");
        }
    }

    private boolean hasRole(Authentication authentication, Role role) {
        return authentication.getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals("ROLE_" + role.name()));
    }

    private UserDetailsDTO convertUserToDTO(User user) {
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
        userDetailsDTO.setNic(user.getNic());
        userDetailsDTO.setName(user.getName());
        userDetailsDTO.setEmail(user.getEmail());
        userDetailsDTO.setRole(user.getRole());
        return userDetailsDTO;
    }
}
