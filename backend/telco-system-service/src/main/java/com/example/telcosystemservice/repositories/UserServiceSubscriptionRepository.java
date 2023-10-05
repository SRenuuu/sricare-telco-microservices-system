package com.example.telcosystemservice.repositories;

import com.example.telcosystemservice.models.UserPackageActivation;
import com.example.telcosystemservice.models.UserServiceSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UserServiceSubscriptionRepository extends JpaRepository<UserServiceSubscription, UUID> {
    @Query("SELECT uss FROM UserServiceSubscription uss WHERE uss.user.id = :userId")
    List<UserServiceSubscription> findAllByUserId(UUID userId);
}
