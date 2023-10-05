package com.example.telcosystemservice.repositories;

import com.example.telcosystemservice.models.VoiceUsage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VoiceUsageRepository extends JpaRepository<VoiceUsage, UUID> {
}
