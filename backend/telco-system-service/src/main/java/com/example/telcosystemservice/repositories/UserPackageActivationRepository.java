package com.example.telcosystemservice.repositories;

import com.example.telcosystemservice.models.UserPackageActivation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserPackageActivationRepository extends JpaRepository<UserPackageActivation, UUID> {
}
