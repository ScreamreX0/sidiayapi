package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    @Query(value = "SELECT * " +
            "FROM users " +
            "WHERE users.user_email = ?1 AND users.user_password = ?2", nativeQuery = true)
    Users findByEmailAndPassword(String email, String password);
}
