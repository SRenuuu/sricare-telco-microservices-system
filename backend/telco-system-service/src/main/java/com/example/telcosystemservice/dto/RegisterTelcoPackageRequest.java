package com.example.telcosystemservice.dto;

import com.example.telcosystemservice.models.PayType;
import com.example.telcosystemservice.models.ServiceType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

public class RegisterTelcoPackageRequest {
    @Getter
    private String name;

    @Getter
    private Float price;

    @Getter
    private Integer size;

    @Getter
    private PayType payType;

    @Getter
    private ServiceType serviceType;
}
