package com.example.telcosystemservice.services;

import com.example.telcosystemservice.dto.AddUsageRequest;
import com.example.telcosystemservice.dto.AnyResponse;
import com.example.telcosystemservice.models.*;
import com.example.telcosystemservice.repositories.DataUsageRepository;
import com.example.telcosystemservice.repositories.VoiceUsageRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class VoiceDataUsageService {
    private final VoiceUsageRepository voiceUsageRepository;
    private final DataUsageRepository dataUsageRepository;
    private final UserSubscriptionService userSubscriptionService;
    private final UserPackageActivationService userPackageActivationService;


    public VoiceDataUsageService(VoiceUsageRepository voiceUsageRepository, DataUsageRepository dataUsageRepository, UserSubscriptionService userSubscriptionService, UserPackageActivationService userPackageActivationService) {
        this.voiceUsageRepository = voiceUsageRepository;
        this.dataUsageRepository = dataUsageRepository;
        this.userSubscriptionService = userSubscriptionService;
        this.userPackageActivationService = userPackageActivationService;
    }

    public AnyResponse addUsage(AddUsageRequest addUsageRequest) {

        Optional<UserPackageActivation> userPackageActivationOptional = userPackageActivationService.reduceRemainingAmount(addUsageRequest.getUserPackageActivationId(), addUsageRequest.getUsage());
        if (userPackageActivationOptional.isPresent()) {
            UserPackageActivation userPackageActivation = userPackageActivationOptional.get();
            User user = userPackageActivation.getUser();

            Optional<UserSubscription> userSubscriptionOptional = userSubscriptionService.findByUserId(user.getId());

            if (userSubscriptionOptional.isEmpty()) return null;
            UserSubscription userSubscription = userSubscriptionOptional.get();

            long currentTimeMillis = System.currentTimeMillis();
            Timestamp currentTimestamp = new Timestamp(currentTimeMillis);

            switch (userPackageActivation.getTelcoPackage().getServiceType()) {
                case VOICE:
                    userSubscription.setVoiceBalance(userSubscription.getVoiceBalance() - addUsageRequest.getUsage());

                    VoiceUsage voiceUsage = VoiceUsage.builder()
                            .activation(userPackageActivation)
                            .recordDateTime(currentTimestamp)
                            .usage(addUsageRequest.getUsage())
                            .build();

                    voiceUsage = voiceUsageRepository.save(voiceUsage);

                    return AnyResponse.builder().message("Usage added").data(voiceUsage).build();

                case DATA:
                    userSubscription.setVoiceBalance(userSubscription.getVoiceBalance() - addUsageRequest.getUsage());

                    DataUsage dataUsage = DataUsage.builder()
                            .activation(userPackageActivation)
                            .recordDateTime(currentTimestamp)
                            .usage(addUsageRequest.getUsage())
                            .build();

                    dataUsage =  dataUsageRepository.save(dataUsage);

                    return AnyResponse.builder().message("Usage added").data(dataUsage).build();
            }


        }else {
            return AnyResponse.builder().message("Package has been expired or not available").data(null).build();
        }

        return null;
    }
}
