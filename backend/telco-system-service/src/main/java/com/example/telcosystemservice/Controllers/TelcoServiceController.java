package com.example.telcosystemservice.Controllers;

import com.example.telcosystemservice.dto.DeactivatePackageRequest;
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
    public TelcoService addTelcoService(@RequestBody RegisterTelcoServiceRequest registerTelcoServiceRequest) {
        TelcoService telcoService = TelcoService.builder()
                .name(registerTelcoServiceRequest.getName())
                .price(registerTelcoServiceRequest.getPrice())
                .status(registerTelcoServiceRequest.getStatus())
                .build();

        return telcoServiceService.addTelcoService(telcoService);
    }

    @GetMapping("/view")
    public List<TelcoService> getAllTelcoServices() {
        return telcoServiceService.getAllTelcoServices();
    }

    @PostMapping("/subscribe")
    public UserServiceSubscription subscribeToService(@RequestBody SubscribeTelcoServiceRequest subscribeTelcoServiceRequest) {
//        @TODO: does not return the entire UserServiceSubscription object
        return userServiceSubscriptionService.subscribeService(subscribeTelcoServiceRequest);
    }

    @GetMapping("/list")
    public List<UserServiceSubscription> getServiceSubscriptionByUser(@RequestParam String user) {
        return userServiceSubscriptionService.findUserSubscribedServices(user);
    }

    @PatchMapping("/deactivate")
    public UserServiceSubscription deactivate(@RequestBody UnsubscribeServiceRequest unsubscribeServiceRequest) {
        return userServiceSubscriptionService.unsubscribeService(unsubscribeServiceRequest);
    }

}
