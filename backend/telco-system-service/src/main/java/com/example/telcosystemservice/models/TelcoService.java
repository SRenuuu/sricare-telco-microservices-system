package com.example.telcosystemservice.models;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Entity
@Builder
@Table(name = "telco_service")
public class TelcoService {

    @Getter
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

    public TelcoService(UUID id, String name, Float price, Status status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
    }

    public TelcoService() {

    }
}
