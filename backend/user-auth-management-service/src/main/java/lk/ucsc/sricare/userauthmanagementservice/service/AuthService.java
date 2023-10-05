package lk.ucsc.sricare.userauthmanagementservice.service;

import lk.ucsc.sricare.userauthmanagementservice.dto.EmailPasswordLoginRequest;
import lk.ucsc.sricare.userauthmanagementservice.dto.JwtAuthenticationResponse;
import lk.ucsc.sricare.userauthmanagementservice.dto.RegistrationRequest;

public interface AuthService {
    void registerUser(RegistrationRequest registrationRequest);
    JwtAuthenticationResponse loginUserByEmailAndPassword(EmailPasswordLoginRequest emailPasswordLoginRequest);
}
