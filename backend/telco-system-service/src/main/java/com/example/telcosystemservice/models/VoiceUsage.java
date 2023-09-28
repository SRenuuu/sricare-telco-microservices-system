package com.example.telcosystemservice.models;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Builder
@Table(name = "voice_usage")
public class VoiceUsage implements Usage{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Getter
    @ManyToOne
    @JoinColumn(name = "activation_id", nullable = true)
    private UserPackageActivation activation;

    @Getter
    @Column(name = "record_dt", nullable = false)
    private Timestamp recordDateTime;

    @Getter
    @Column(nullable = false)
    private Integer usage;

    public VoiceUsage(UUID id, UserPackageActivation activation, Timestamp recordDateTime, Integer usage) {
        this.id = id;
        this.activation = activation;
        this.recordDateTime = recordDateTime;
        this.usage = usage;
    }

    public VoiceUsage() {

    }


}
