package com.example.telcosystemservice.repositories;

import com.example.telcosystemservice.models.UserSubscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserSubscriptionRepository extends JpaRepository<UserSubscription, UUID> {
    Optional<UserSubscription> findFirstByUserId(UUID userId);
}

