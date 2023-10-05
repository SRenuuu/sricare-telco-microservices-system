package com.example.telcosystemservice.controllers;

import com.example.telcosystemservice.dto.AnyResponse;
import com.example.telcosystemservice.dto.RegisterTelcoServiceRequest;
import com.example.telcosystemservice.dto.SubscribeTelcoServiceRequest;
import com.example.telcosystemservice.dto.UnsubscribeServiceRequest;
import com.example.telcosystemservice.models.TelcoService;
import com.example.telcosystemservice.models.UserServiceSubscription;
import com.example.telcosystemservice.services.TelcoServiceService;
import com.example.telcosystemservice.services.UserServiceSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
public class TelcoServiceController {

    private final TelcoServiceService telcoServiceService;
    private final UserServiceSubscriptionService userServiceSubscriptionService;

    @Autowired
    public TelcoServiceController(TelcoServiceService telcoServiceService, UserServiceSubscriptionService userServiceSubscriptionService) {
        this.telcoServiceService = telcoServiceService;
        this.userServiceSubscriptionService = userServiceSubscriptionService;
    }


    @PostMapping("/add")
    public AnyResponse addTelcoService(@RequestBody RegisterTelcoServiceRequest registerTelcoServiceRequest) {
        TelcoService telcoService = TelcoService.builder()
                .name(registerTelcoServiceRequest.getName())
                .price(registerTelcoServiceRequest.getPrice())
                .status(registerTelcoServiceRequest.getStatus())
                .build();

        return telcoServiceService.addTelcoService(telcoService);
    }

    @GetMapping("/view")
    public AnyResponse getAllTelcoServices() {
        return telcoServiceService.getAllTelcoServices();
    }

    @PostMapping("/subscribe")
    public AnyResponse subscribeToService(@RequestBody SubscribeTelcoServiceRequest subscribeTelcoServiceRequest) {
        return userServiceSubscriptionService.subscribeService(subscribeTelcoServiceRequest);
    }

    @GetMapping("/list")
    public AnyResponse getServiceSubscriptionByUser(@RequestParam String user) {
        return userServiceSubscriptionService.findUserSubscribedServices(user);
    }

    @PatchMapping("/deactivate")
    public AnyResponse deactivate(@RequestBody UnsubscribeServiceRequest unsubscribeServiceRequest) {
        return userServiceSubscriptionService.unsubscribeService(unsubscribeServiceRequest);
    }

}
