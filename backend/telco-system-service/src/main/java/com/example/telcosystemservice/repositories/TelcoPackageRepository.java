package com.example.telcosystemservice.repositories;

import com.example.telcosystemservice.models.TelcoPackage;
import com.example.telcosystemservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TelcoPackageRepository extends JpaRepository<TelcoPackage, UUID> {
}
