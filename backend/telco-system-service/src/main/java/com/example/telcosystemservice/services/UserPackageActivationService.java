package com.example.telcosystemservice.services;

import com.example.telcosystemservice.dto.ActivateTelcoPackageRequest;
import com.example.telcosystemservice.models.Status;
import com.example.telcosystemservice.models.TelcoPackage;
import com.example.telcosystemservice.models.User;
import com.example.telcosystemservice.models.UserPackageActivation;
import com.example.telcosystemservice.repositories.TelcoPackageRepository;
import com.example.telcosystemservice.repositories.UserPackageActivationRepository;
import com.example.telcosystemservice.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserPackageActivationService {
    private final UserPackageActivationRepository userPackageActivationRepository;
    private final UserRepository userRepository;
    private final TelcoPackageRepository telcoPackageRepository;

    public UserPackageActivationService(UserPackageActivationRepository userPackageActivationRepository, UserRepository userRepository, TelcoPackageRepository telcoPackageRepository) {
        this.userPackageActivationRepository = userPackageActivationRepository;
        this.userRepository = userRepository;
        this.telcoPackageRepository = telcoPackageRepository;
    }

    public UserPackageActivation activatePackage(ActivateTelcoPackageRequest activateTelcoPackageRequest) {

        Optional<User> userOptional = userRepository.findById(activateTelcoPackageRequest.getUserId());
        Optional<TelcoPackage> telcoPackageOptional = telcoPackageRepository.findById(activateTelcoPackageRequest.getTelcoPackageId());

        if (userOptional.isPresent() && telcoPackageOptional.isPresent()) {
            User user = userOptional.get();
            TelcoPackage telcoPackage = telcoPackageOptional.get();

            long currentTimeMillis = System.currentTimeMillis();
            Timestamp currentTimestamp = new Timestamp(currentTimeMillis);

            UserPackageActivation userPackageActivation = UserPackageActivation.builder()
                    .user(user)
                    .telcoPackage(telcoPackage)
                    .activatedDateTime(currentTimestamp)
                    .status(Status.ACTIVE)
                    .build();

            return userPackageActivationRepository.save(userPackageActivation);

        }else {
            return null;
        }


    }
}
