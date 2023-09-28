package com.example.telcosystemservice.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

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
    @Column(nullable = false)
    private String email;

    public User(String nic, String fullName, Date dob, String email) {
        this.nic = nic;
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
    }


    public User() {

    }

}
