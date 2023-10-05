package com.example.telcosystemservice.dto;

import java.util.UUID;

import lombok.Getter;

public class DeactivatePackageRequest {

    @Getter
    private UUID userPackageActivationId;
}
