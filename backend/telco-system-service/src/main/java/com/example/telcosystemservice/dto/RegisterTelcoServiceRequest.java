package com.example.telcosystemservice.dto;

import com.example.telcosystemservice.models.Status;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

public class RegisterTelcoServiceRequest {
    @Getter
    private String name;

    @Getter
    private Float price;

    @Getter
    private Status status;
}
