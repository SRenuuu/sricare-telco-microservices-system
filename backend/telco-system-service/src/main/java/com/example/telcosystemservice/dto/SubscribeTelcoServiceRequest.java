package com.example.telcosystemservice.dto;

import lombok.Getter;

import java.util.UUID;

public class SubscribeTelcoServiceRequest {
    @Getter
    private UUID userId;
    @Getter
    private UUID telcoServiceId;
}
