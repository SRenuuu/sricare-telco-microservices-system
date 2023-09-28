package com.example.telcosystemservice.models;

import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "user_package_activation")
public class UserPackageActivation {

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
    @JoinColumn(name = "package_id", nullable = false)
    private TelcoPackage telcoPackage;

    @Getter
    @Column(name = "activated_dt", nullable = false)
    private Timestamp activatedDateTime;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    public UserPackageActivation(User user, TelcoPackage telcoPackage, Timestamp activatedDateTime, Status status) {
        this.user = user;
        this.telcoPackage = telcoPackage;
        this.activatedDateTime = activatedDateTime;
        this.status = status;
    }

    public UserPackageActivation() {

    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
