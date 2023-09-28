package com.example.telcosystemservice.model;


import jakarta.persistence.*;

@Entity
@Table(name = "telco_service")
public class TelcoService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Float price;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

}
