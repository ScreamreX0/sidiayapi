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
            WHERE t.author = :id
            """, nativeQuery = true)
    List<Tickets> findOperatorTickets(@Param("id") Long id);

    /**
     * Tickets status 2 - NEW
     */
    @Query(value = """
            SELECT *
            FROM tickets t
            WHERE t.status = 2
            """, nativeQuery = true)
    List<Tickets> findDispatcherTickets();

    /**
     * Ticket statuses
     * 3 - EVALUATED
     * 7 - COMPLETED
     * 10 - FOR_REVISION
     */
    @Query(value = """
            SELECT *
            FROM tickets t
            WHERE t.status = 3 or t.status = 7 or t.status = 10
            """, nativeQuery = true)
    List<Tickets> findSectionChiefTickets();

    @Query(value = """
                 SELECT t.*
                 FROM tickets t
                 JOIN tickets_quality_controllers tqc
                     ON tqc.ticket_id = t.id
                 JOIN users u
                     ON tqc.quality_controller_id = u.id
                 WHERE u.id = :id
            """, nativeQuery = true)
    List<Tickets> findQualityControlSpecialistTickets(@Param("id") Long id);

    @Query(value = """
                SELECT t.*
                FROM tickets t
                JOIN tickets_executors te
                    ON te.ticket_id = t.id
                JOIN users u
                    ON te.executor_id = u.id
                WHERE u.id = :id
            """, nativeQuery = true)
    List<Tickets> findTicketsByExecutorId(@Param("id") Long id);
}
