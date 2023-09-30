package com.example.telcosystemservice.services;

import com.example.telcosystemservice.dto.AnyResponse;
import com.example.telcosystemservice.dto.CreateUserSubscriptionRequest;
import com.example.telcosystemservice.dto.ReloadRequest;
import com.example.telcosystemservice.models.*;
import com.example.telcosystemservice.repositories.UserRepository;
import com.example.telcosystemservice.repositories.UserSubscriptionRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserSubscriptionService {
    private UserSubscriptionRepository userSubscriptionRepository;
    private UserRepository userRepository;

    public  UserSubscriptionService(UserSubscriptionRepository userSubscriptionRepository, UserRepository userRepository) {
        this.userSubscriptionRepository = userSubscriptionRepository;
        this.userRepository = userRepository;
    }

    public AnyResponse subscribe(CreateUserSubscriptionRequest createUserSubscriptionRequest) {

        Optional<User> userOptional = userRepository.findById(createUserSubscriptionRequest.getUserId());

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            long currentTimeMillis = System.currentTimeMillis();
            Timestamp currentTimestamp = new Timestamp(currentTimeMillis);

            UserSubscription userSubscription = UserSubscription.builder()
                    .user(user)
                    .basePackage(createUserSubscriptionRequest.getBasePackage())
                    .phone(createUserSubscriptionRequest.getPhone())
                    .payType(createUserSubscriptionRequest.getPayType())
                    .reloadBalance(0)
                    .voiceBalance(0)
                    .dataBalance(0)
                    .outstandingAmount(0)
                    .build();

            userSubscription = userSubscriptionRepository.save(userSubscription);
            return AnyResponse.builder().message("Subscribed").data(userSubscription).build();

        }else {
            return AnyResponse.builder().message("Subscription failed").data(null).build();
        }


    }

    public Optional<UserSubscription> updateReloadBalance(UUID id, int amount) {
        Optional<UserSubscription> userSubscriptionOptional = userSubscriptionRepository.findById(id);

        if (userSubscriptionOptional.isPresent()) {
            UserSubscription userSubscription = userSubscriptionOptional.get();
            userSubscription.setReloadBalance(userSubscription.getReloadBalance() + amount);

            return Optional.of(userSubscription);
        }

        return Optional.empty();
    }

    public Optional<UserSubscription> updateVoiceBalance(UUID id, int amount) {
        Optional<UserSubscription> userSubscriptionOptional = userSubscriptionRepository.findById(id);

        if (userSubscriptionOptional.isPresent()) {
            UserSubscription userSubscription = userSubscriptionOptional.get();
            userSubscription.setVoiceBalance(userSubscription.getVoiceBalance() + amount);

            return Optional.of(userSubscription);
        }

        return Optional.empty();
    }

    public Optional<UserSubscription> updateDateBalance(UUID id, int amount) {
        Optional<UserSubscription> userSubscriptionOptional = userSubscriptionRepository.findById(id);

        if (userSubscriptionOptional.isPresent()) {
            UserSubscription userSubscription = userSubscriptionOptional.get();
            userSubscription.setDataBalance(userSubscription.getDataBalance() + amount);

            return Optional.of(userSubscription);
        }

        return Optional.empty();
    }

    public Optional<UserSubscription> updateOutstandingBalance(UUID id, int amount) {
        Optional<UserSubscription> userSubscriptionOptional = userSubscriptionRepository.findById(id);

        if (userSubscriptionOptional.isPresent()) {
            UserSubscription userSubscription = userSubscriptionOptional.get();
            userSubscription.setOutstandingAmount(userSubscription.getOutstandingAmount() + amount);

            return Optional.of(userSubscription);
        }

        return Optional.empty();
    }

    public Optional<UserSubscription> findByUserId(UUID userId) {
        return userSubscriptionRepository.findFirstByUserId(userId);
    }

    public AnyResponse updateReloadBalance(ReloadRequest reloadRequest) {
        Optional<UserSubscription> userSubscriptionOptional = this.findByUserId(reloadRequest.getUserId());

        if (userSubscriptionOptional.isPresent()) {

            UserSubscription userSubscription = userSubscriptionOptional.get();
            userSubscription.setReloadBalance(userSubscription.getReloadBalance() + reloadRequest.getAmount());

            userSubscription = userSubscriptionRepository.save(userSubscription);
            return AnyResponse.builder().message("Reloading successful").data(userSubscription).build();

        } else {
            return AnyResponse.builder().message("User does not exist").data(null).build();
        }
    }
}
