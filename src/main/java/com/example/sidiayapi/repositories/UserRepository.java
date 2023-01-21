package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    @Query(value = "SELECT * " +
            "FROM users " +
            "WHERE users.user_email = :email AND users.user_password = :password", nativeQuery = true)
    Users findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
