package com.example.telcosystemservice.repositories;

import com.example.telcosystemservice.models.UserServiceSubscription;
import com.example.telcosystemservice.models.UserSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserSubscriptionRepository extends JpaRepository<UserSubscription, UUID> {
    @Query("SELECT us FROM UserSubscription us WHERE us.user.id = :userId limit 1")
    Optional<UserSubscription> findOneByUserId(UUID userId);
}
