package com.backend.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.api.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByName(String name);
}
