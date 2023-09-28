package com.example.telcosystemservice.repositories;

import com.example.telcosystemservice.models.UserPackageActivation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UserPackageActivationRepository extends JpaRepository<UserPackageActivation, UUID> {
    @Query("SELECT upa FROM UserPackageActivation upa WHERE upa.user.id = :userId")
    List<UserPackageActivation> findAllByUserId(UUID userId);
}
