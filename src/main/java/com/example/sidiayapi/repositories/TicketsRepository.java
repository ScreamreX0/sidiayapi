package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketsRepository extends JpaRepository<Tickets, Long> {
    /**
     * Gets only its own tickets
     */
    @Query(value = """
            SELECT *
            FROM tickets t
            WHERE t.author = :id
            """, nativeQuery = true)
    List<Tickets> findOperatorTickets(@Param("id") Long id);

    /**
     * Gets tickets where status is NEW
     */
    @Query(value = """
            SELECT *
            FROM tickets t
            WHERE t.status = 2 AND t.field = :field_id
            """, nativeQuery = true)
    List<Tickets> findDispatcherTickets(@Param("field_id") Long field_id);

    /**
     * Gets tickets where status EVALUATED or COMPLETED or FOR_REVISION and matches ticket's field
     */
    @Query(value = """
            SELECT *
            FROM tickets t
            WHERE t.status IN (3, 7, 10)
                AND t.field = :field_id
            """, nativeQuery = true)
    List<Tickets> findSectionChiefTickets(@Param("field_id") Long field_id);

    /**
     * Gets tickets where status EVALUATED or COMPLETED or FOR_REVISION
     * and matches ticket's field and matches department
     */
    @Query(value = """
            SELECT *
            FROM tickets t
            WHERE t.status in (3, 7, 10)
                AND t.field = :field_id
                AND service in (1, 2, 3, 4, 7)
            """, nativeQuery = true)
    List<Tickets> findChiefEngineerTickets(@Param("field_id") Long field_id);

    /**
     * Gets tickets where status EVALUATED or COMPLETED or FOR_REVISION
     * and matches ticket's field and matches department
     */
    @Query(value = """
            SELECT *
            FROM tickets t
            WHERE t.status in (3, 7, 10)
                AND t.field = :field_id
                AND service in (5, 6)
            """, nativeQuery = true)
    List<Tickets> findChiefGeologistTickets(@Param("field_id") Long field_id);

    /**
     * Gets tickets where status QUALITY_CHECKING
     * and matches ticket's field,
     * and he listed as quality controller
     */
    @Query(value = """
            SELECT t.*
            FROM tickets t
            JOIN tickets_quality_controllers tqc
                ON tqc.ticket_id = t.id
            JOIN users u
                ON tqc.quality_controller_id = u.id
            WHERE u.id = :id
                AND t.status = 8
                AND t.field = :field_id
            """, nativeQuery = true)
    List<Tickets> findQualityControlSpecialistTickets(@Param("id") Long id, @Param("field_id") Long field_id);

    /**
     * Gets only its own tickets
     */
    @Query(value = """
            SELECT t.*
            FROM tickets t
            JOIN tickets_executors te
                ON te.ticket_id = t.id
            JOIN users u
                ON te.executor_id = u.id
            WHERE u.id = :id
                AND t.field = :field_id
            """, nativeQuery = true)
    List<Tickets> findTicketsByExecutorId(@Param("id") Long id, @Param("field_id") Long field_id);
}
