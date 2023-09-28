package com.example.telcosystemservice.dto;

import com.example.telcosystemservice.models.PayType;
import com.example.telcosystemservice.models.User;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

public class CreateUserSubscriptionRequest {

    @Getter
    private UUID userId;

    @Getter
    private PayType payType;

    @Getter
    private String phone;

    @Getter
    private String basePackage;

}
