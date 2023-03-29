package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketsRepository extends JpaRepository<Tickets, Long> {
    @Query(value = """
            SELECT *
                FROM tickets t
                WHERE t.author_id = :id
                    OR t.executor_id = :id
            """,
            nativeQuery = true)
    List<Tickets> findTicketsByUserId(@Param("id") Long id);
}
