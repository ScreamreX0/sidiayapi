package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
