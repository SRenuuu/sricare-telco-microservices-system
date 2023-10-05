package com.example.telcosystemservice.dto;

import lombok.Getter;

import java.util.UUID;

public class UnsubscribeServiceRequest {
    @Getter
    private UUID userServiceSubscriptionId;
}
