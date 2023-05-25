package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    @Query(value = """
            SELECT u.*
            FROM users u
            LEFT JOIN employees e
                ON e.id = u.employee_id
            WHERE u.password = :password
                AND e.email = :email
                    """,
            nativeQuery=true)
    Users findByCredentials(@Param("email") String email, @Param("password") String password);

    @Query(value = """
            SELECT u.*
            FROM users u
            LEFT JOIN employees e
                ON u.employee_id = e.id
            LEFT JOIN subdivisions s
                ON e.subdivision_id = s.id
            WHERE s.field_id = :field
            """, nativeQuery = true)
    List<Users> findByField(@Param("field") Long field);

    @Query(value = """
            SELECT u.*
            FROM tickets_subscriptions ts
            LEFT JOIN users u
                ON u.id = ts.user_id
            WHERE ticket_id = :ticket_id
            """, nativeQuery = true)
    List<Users> findSubscribersByTicketId(@Param("ticket_id") Long ticket_id);
}
