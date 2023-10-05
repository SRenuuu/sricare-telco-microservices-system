package com.example.telcosystemservice.services;

import com.example.telcosystemservice.dto.*;
import com.example.telcosystemservice.models.*;
import com.example.telcosystemservice.repositories.TelcoServiceRepository;
import com.example.telcosystemservice.repositories.UserRepository;
import com.example.telcosystemservice.repositories.UserServiceSubscriptionRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    public AnyResponse subscribeService(SubscribeTelcoServiceRequest subscribeTelcoServiceRequest) {

        Optional<User> userOptional = userRepository.findById(subscribeTelcoServiceRequest.getUserId());
        Optional<TelcoService> telcoServiceOptional = telcoServiceRepository.findById(subscribeTelcoServiceRequest.getTelcoServiceId());

        if (userOptional.isPresent() && telcoServiceOptional.isPresent()) {
            User user = userOptional.get();
            TelcoService telcoService = telcoServiceOptional.get();

            if (telcoService.getStatus() == Status.OUTDATED) {

                return AnyResponse.builder().message("Cannot subscribe to an outdated service").data(null).build();
            }

            long currentTimeMillis = System.currentTimeMillis();
            Timestamp currentTimestamp = new Timestamp(currentTimeMillis);

            UserServiceSubscription userServiceSubscription = UserServiceSubscription.builder()
                    .user(user)
                    .telcoService(telcoService)
                    .activatedDateTime(currentTimestamp)
                    .status(Status.ACTIVE)
                    .build();

            userServiceSubscription = userServiceSubscriptionRepository.save(userServiceSubscription);
            return AnyResponse.builder().message("Subscribed to service successfully").data(userServiceSubscription).build();

        }else {
            return AnyResponse.builder().message("Could not subscribe to the service").data(null).build();
        }

    }

    public AnyResponse unsubscribeService(UnsubscribeServiceRequest unsubscribeServiceRequest) {
        Optional<UserServiceSubscription> userServiceSubscriptionOptional = userServiceSubscriptionRepository.findById(unsubscribeServiceRequest.getUserServiceSubscriptionId());

        if (userServiceSubscriptionOptional.isPresent()) {
            UserServiceSubscription userServiceSubscription = userServiceSubscriptionOptional.get();

            if (userServiceSubscription.getStatus() == Status.ACTIVE) {
                userServiceSubscription.setStatus(Status.OUTDATED);

                userServiceSubscription = userServiceSubscriptionRepository.save(userServiceSubscription);
            }

            return AnyResponse.builder().message("Unsubscribed successfully").data(userServiceSubscription).build();
        }

        return AnyResponse.builder().message("Could not unsubscribe to the service").data(null).build();
    }

    public AnyResponse findUserSubscribedServices(String userId) {
        UUID user= UUID.fromString(userId);
        List<UserServiceSubscription> subscribedServices = userServiceSubscriptionRepository.findAllByUserId(user);
        return AnyResponse.builder().message("Found services").data(subscribedServices).build();
    }
}
