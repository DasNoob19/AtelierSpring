package com.example.exercisespring.repository;

import com.example.exercisespring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
