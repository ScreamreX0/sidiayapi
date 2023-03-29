package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    @Query(value = """
            SELECT u.*
                FROM users u
                INNER JOIN employees e
                ON e.id = u.employee_id
                WHERE u.password = :password
                    AND e.email = :email""",
            nativeQuery=true)
    Users findByCredentials(@Param("email") String email, @Param("password") String password);
}
