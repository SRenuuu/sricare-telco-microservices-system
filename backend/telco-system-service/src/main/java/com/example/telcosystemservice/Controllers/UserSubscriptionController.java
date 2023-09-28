package com.example.telcosystemservice.Controllers;

import com.example.telcosystemservice.dto.CreateUserSubscriptionRequest;
import com.example.telcosystemservice.models.UserSubscription;
import com.example.telcosystemservice.services.UserSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-subscription")
public class UserSubscriptionController {

    private final UserSubscriptionService userSubscriptionService;

    @Autowired
    public UserSubscriptionController(UserSubscriptionService userSubscriptionService) {
        this.userSubscriptionService = userSubscriptionService;
    }

    @PostMapping("/add")
    public UserSubscription subscribe(@RequestBody CreateUserSubscriptionRequest createUserSubscriptionRequest) {
        return userSubscriptionService.subscribe(createUserSubscriptionRequest);
    }
}
