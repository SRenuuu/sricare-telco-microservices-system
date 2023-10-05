package com.example.telcosystemservice.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.sql.Date;

public class RegisterUserRequest {
    @Getter
    private String nic;

    @Getter
    private String fullName;

    @Getter
    private Date dob;

    @Getter
    private String email;
}
