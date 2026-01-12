package com.spring.app.repository;

import com.spring.app.model.entity.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;
import java.util.UUID;

public interface ApiUserRepository extends JpaRepository<ApiUser, UUID> {
    Optional<UserDetails> findByLogin(String login);
}
