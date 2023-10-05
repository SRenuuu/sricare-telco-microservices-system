package com.example.telcosystemservice.services;

import com.example.telcosystemservice.dto.ActivateTelcoPackageRequest;
import com.example.telcosystemservice.dto.AnyResponse;
import com.example.telcosystemservice.dto.DeactivatePackageRequest;
import com.example.telcosystemservice.models.*;
import com.example.telcosystemservice.repositories.TelcoPackageRepository;
import com.example.telcosystemservice.repositories.UserPackageActivationRepository;
import com.example.telcosystemservice.repositories.UserRepository;
import com.example.telcosystemservice.repositories.UserSubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserPackageActivationService {
    private final UserPackageActivationRepository userPackageActivationRepository;
    private final UserRepository userRepository;
    private final TelcoPackageRepository telcoPackageRepository;
    private final UserSubscriptionRepository userSubscriptionRepository;

    @Autowired
    public UserPackageActivationService(UserPackageActivationRepository userPackageActivationRepository, UserRepository userRepository, TelcoPackageRepository telcoPackageRepository, UserSubscriptionRepository userSubscriptionRepository) {
        this.userPackageActivationRepository = userPackageActivationRepository;
        this.userRepository = userRepository;
        this.telcoPackageRepository = telcoPackageRepository;
        this.userSubscriptionRepository = userSubscriptionRepository;
    }

    public AnyResponse activatePackage(ActivateTelcoPackageRequest activateTelcoPackageRequest) {

        Optional<User> userOptional = userRepository.findById(activateTelcoPackageRequest.getUserId());
        Optional<TelcoPackage> telcoPackageOptional = telcoPackageRepository.findById(activateTelcoPackageRequest.getTelcoPackageId());
        Optional<UserSubscription> userSubscriptionOptional = userSubscriptionRepository.findFirstByUserId(activateTelcoPackageRequest.getUserId());

//        Is user is present and telco package is present and user has a base subscription
        if (userOptional.isPresent() && telcoPackageOptional.isPresent() && userSubscriptionOptional.isPresent()) {
            User user = userOptional.get();
            TelcoPackage telcoPackage = telcoPackageOptional.get();
            UserSubscription userSubscription = userSubscriptionOptional.get();

//            Activate only user has sufficient amount in the account
            if (userSubscription.getReloadBalance() < telcoPackage.getPrice())  return AnyResponse.builder()
                    .message("Account balance is not sufficient")
                    .data(null).build();

//            Deduct the amount
            userSubscription.setReloadBalance((int) (userSubscription.getReloadBalance()- telcoPackage.getPrice()));
            userSubscriptionRepository.save(userSubscription);

            long currentTimeMillis = System.currentTimeMillis();
            Timestamp currentTimestamp = new Timestamp(currentTimeMillis);

            UserPackageActivation userPackageActivation = UserPackageActivation.builder()
                    .user(user)
                    .telcoPackage(telcoPackage)
                    .activatedDateTime(currentTimestamp)
                    .status(Status.ACTIVE)
                    .build();

//            After activating the package, update UserSubscription object
            switch (telcoPackage.getServiceType()) {
                case VOICE:
                    userSubscription.setVoiceBalance(telcoPackage.getSize());
                    break;

                case DATA:
                    userSubscription.setDataBalance(telcoPackage.getSize());
                    break;
            }

            userSubscriptionRepository.save(userSubscription);
            userPackageActivation = userPackageActivationRepository.save(userPackageActivation);
            return AnyResponse.builder().message("Package activated successfully").data(userPackageActivation).build();

        }else {
            return AnyResponse.builder().message("This user cannot activate specified package").data(null).build();
        }


    }

    public AnyResponse deactivatePackage(DeactivatePackageRequest deactivatePackageRequest) {
        Optional<UserPackageActivation> userPackageActivationOptional = userPackageActivationRepository.findById(deactivatePackageRequest.getUserPackageActivationId());

        if (userPackageActivationOptional.isPresent()) {
           UserPackageActivation userPackageActivation = userPackageActivationOptional.get();

           if (userPackageActivation.getStatus() == Status.ACTIVE) {
               userPackageActivation.setStatus(Status.OUTDATED);

               userPackageActivation = userPackageActivationRepository.save(userPackageActivation);
           }

            return AnyResponse.builder().message("Package deactivated successfully").data(userPackageActivation).build();
        }

//        TODO: Before returning - deduct the amount of left in this package from userSubscription  (total amount)

        return AnyResponse.builder().message("Package deactivation failed").data(null).build();
    }

    public AnyResponse findUserActivatedPackages(String userId) {
        UUID user= UUID.fromString(userId);
        List<UserPackageActivation> activatedPackages = userPackageActivationRepository.findAllByUserId(user);
        return AnyResponse.builder().message("Found packages").data(activatedPackages).build();

    }

//    Deducts the used amount from the given packageActivation - is Package is already Outdated, returns null, else returns whether that package is VOICE or DATA
    public Optional<UserPackageActivation> reduceRemainingAmount(UUID id, Integer amount) {
        Optional<UserPackageActivation> userPackageActivationOptional = userPackageActivationRepository.findById(id);

        if (userPackageActivationOptional.isPresent()) {
            UserPackageActivation userPackageActivation = userPackageActivationOptional.get();

            if (userPackageActivation.getStatus() == Status.OUTDATED) return Optional.empty();

            if (userPackageActivation.getRemaining() - amount > 0) {
                userPackageActivation.setRemaining(userPackageActivation.getRemaining() - amount);
            }
            else {
                userPackageActivation.setRemaining(0);
                userPackageActivation.setStatus(Status.OUTDATED);

            }

            return Optional.of(userPackageActivation);
        }

        return Optional.empty();
    }

    public Optional<User> findUserByUserPackageActivationId(UUID id) {
        Optional<UserPackageActivation> userPackageActivationOptional = userPackageActivationRepository.findById(id);

        if (userPackageActivationOptional.isPresent()) {
            UserPackageActivation userPackageActivation = userPackageActivationOptional.get();
            return Optional.of(userPackageActivation.getUser());
        }

        return Optional.empty();
    }
}
