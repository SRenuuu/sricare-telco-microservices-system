package com.example.telcosystemservice.repositories;

import com.example.telcosystemservice.models.TelcoService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TelcoServiceRepository extends JpaRepository<TelcoService, UUID> {
    Optional<TelcoService> findById(UUID id);
}