package com.example.telcosystemservice.models;


import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Entity
@Table(name = "telco_service")
public class TelcoService {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Getter
    @Column(nullable = false)
    private String name;

    @Getter
    @Column(nullable = false)
    private Float price;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

}
