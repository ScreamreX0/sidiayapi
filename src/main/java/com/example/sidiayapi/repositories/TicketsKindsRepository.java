package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.TicketKinds;
import com.example.sidiayapi.entities.Users;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketsKindsRepository extends JpaRepository<TicketKinds, Long> {
    @Query(value = "SELECT * " +
            "FROM ticket_kinds " +
            "WHERE ticket_kinds.id = :id", nativeQuery = true)
    TicketKinds getById(@Param("id") String id);
}
