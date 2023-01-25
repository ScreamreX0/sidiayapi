package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.TicketKinds;
import com.example.sidiayapi.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    @Query(value = "SELECT * " +
            "FROM users " +
            "WHERE users.email = :email AND users.password = :password", nativeQuery = true)
    Users findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    @Query(value = "SELECT * " +
            "FROM users " +
            "WHERE users.id = :id", nativeQuery = true)
    Users getById(@Param("id") String id);
}
