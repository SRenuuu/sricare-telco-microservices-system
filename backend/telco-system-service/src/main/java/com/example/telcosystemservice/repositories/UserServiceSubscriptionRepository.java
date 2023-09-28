package com.example.telcosystemservice.repositories;

import com.example.telcosystemservice.models.UserServiceSubscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserServiceSubscriptionRepository extends JpaRepository<UserServiceSubscription, UUID> {
}
