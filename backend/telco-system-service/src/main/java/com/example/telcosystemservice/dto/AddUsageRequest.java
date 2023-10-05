package com.example.telcosystemservice.dto;

import lombok.Getter;

import java.util.UUID;

public class AddUsageRequest {
    @Getter
    private UUID userPackageActivationId;

    @Getter
    private Integer usage;
}
