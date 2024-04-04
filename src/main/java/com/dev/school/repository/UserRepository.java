package com.dev.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.school.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
