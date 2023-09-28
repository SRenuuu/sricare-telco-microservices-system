package com.example.telcosystemservice.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.sql.Date;
import java.util.UUID;

@Entity
@Builder
@Table(name = "users")
public class User {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Getter
    @Column(nullable = false)
    private String nic;

    @Getter
    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Getter
    @Column(nullable = true)
    private Date dob;

    @Getter
    @Column(nullable = false, unique = true)
    private String email;

    public User(UUID id, String nic, String fullName, Date dob, String email) {
        this.id = id;
        this.nic = nic;
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
    }


    public User() {

    }

}
