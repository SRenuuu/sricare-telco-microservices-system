package com.example.telcosystemservice.dto;

import lombok.Getter;

import java.util.UUID;

public class ActivateTelcoPackageRequest {
    @Getter
    private UUID userId;
    @Getter
    private UUID telcoPackageId;
}
