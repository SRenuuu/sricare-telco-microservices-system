package com.example.telcosystemservice.models;

import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.UUID;


@Entity
@Table(name = "user_service_subscription")
public class UserServiceSubscription {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private TelcoService telcoService;

    @Column(name = "activated_dt", nullable = false)
    private Timestamp activatedDateTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    public UserServiceSubscription(User user, TelcoService telcoService, Timestamp activatedDateTime, Status status) {
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
