package com.example.telcosystemservice.services;

import com.example.telcosystemservice.dto.ActivateTelcoPackageRequest;
import com.example.telcosystemservice.dto.SubscribeTelcoServiceRequest;
import com.example.telcosystemservice.models.*;
import com.example.telcosystemservice.repositories.TelcoServiceRepository;
import com.example.telcosystemservice.repositories.UserRepository;
import com.example.telcosystemservice.repositories.UserServiceSubscriptionRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class UserServiceSubscriptionService {
    private final UserRepository userRepository;
    private final UserServiceSubscriptionRepository userServiceSubscriptionRepository;
    private final TelcoServiceRepository telcoServiceRepository;

    public UserServiceSubscriptionService(UserRepository userRepository, UserServiceSubscriptionRepository userServiceSubscriptionRepository, TelcoServiceRepository telcoServiceRepository) {
        this.userRepository = userRepository;
        this.userServiceSubscriptionRepository = userServiceSubscriptionRepository;
        this.telcoServiceRepository = telcoServiceRepository;
    }

//    Given the userId and serviceId create the subscription entry
    public UserServiceSubscription subscribeService(SubscribeTelcoServiceRequest subscribeTelcoServiceRequest) {

        Optional<User> userOptional = userRepository.findById(subscribeTelcoServiceRequest.getUserId());
        Optional<TelcoService> telcoServiceOptional = telcoServiceRepository.findById(subscribeTelcoServiceRequest.getTelcoServiceId());

        if (userOptional.isPresent() && telcoServiceOptional.isPresent()) {
            User user = userOptional.get();
            TelcoService telcoService = telcoServiceOptional.get();

            if (telcoService.getStatus() == Status.OUTDATED) {

                return null;
            }

            long currentTimeMillis = System.currentTimeMillis();
            Timestamp currentTimestamp = new Timestamp(currentTimeMillis);

            UserServiceSubscription userServiceSubscription = UserServiceSubscription.builder()
                    .user(user)
                    .telcoService(telcoService)
                    .activatedDateTime(currentTimestamp)
                    .status(Status.ACTIVE)
                    .build();

            return userServiceSubscriptionRepository.save(userServiceSubscription);

        }else {
            return null;
        }


    }
}
