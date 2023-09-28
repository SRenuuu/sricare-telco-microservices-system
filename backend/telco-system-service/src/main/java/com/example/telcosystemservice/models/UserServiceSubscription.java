package com.example.telcosystemservice.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.UUID;


@Entity
@Builder
@Table(name = "user_service_subscription")
public class UserServiceSubscription {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Getter
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Getter
    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private TelcoService telcoService;

    @Getter
    @Column(name = "activated_dt", nullable = false)
    private Timestamp activatedDateTime;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    public UserServiceSubscription(UUID id, User user, TelcoService telcoService, Timestamp activatedDateTime, Status status) {
        this.id = id;
        this.user = user;
        this.telcoService = telcoService;
        this.activatedDateTime = activatedDateTime;
        this.status = status;
    }

    public UserServiceSubscription() {

    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
