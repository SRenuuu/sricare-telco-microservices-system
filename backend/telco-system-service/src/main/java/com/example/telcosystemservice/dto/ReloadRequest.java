package com.example.telcosystemservice.dto;

import lombok.Getter;

import java.util.UUID;

@Getter
public class ReloadRequest {
    private UUID userId;

    private Integer amount;
}
