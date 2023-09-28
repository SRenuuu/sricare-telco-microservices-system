package com.example.telcosystemservice.repositories;

import com.example.telcosystemservice.models.DataUsage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DataUsageRepository extends JpaRepository<DataUsage, UUID> {
}
