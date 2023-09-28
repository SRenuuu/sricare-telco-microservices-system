package com.example.telcosystemservice.model;
import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "data_usage")
public class DataUsage {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Getter
    @ManyToOne
    @JoinColumn(name = "activation_id", nullable = true)
    private UserPackageActivation activation;

    @Getter
    @Column(name = "record_dt", nullable = false)
    private Timestamp recordDate;

    @Getter
    @Column(nullable = false)
    private Integer usage;

    public DataUsage(UserPackageActivation activation, Timestamp recordDate, Integer usage) {
        this.activation = activation;
        this.recordDate = recordDate;
        this.usage = usage;
    }

    public DataUsage() {

    }
}
