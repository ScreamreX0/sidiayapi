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
    List<Tickets> findTicketsByAuthorship(@Param("id") Long id);

    /**
     * Gets tickets where status EVALUATED or COMPLETED or FOR_REVISION and matches ticket's field
     */
    @Query(value = """
            SELECT *
            FROM tickets t
            WHERE t.status IN :statuses
                AND t.field = :field_id
            """, nativeQuery = true)
    List<Tickets> findTicketsByStatusesAndFields(@Param("field_id") Long field_id,
                                                 @Param("statuses") Iterable<Integer> statuses);

    /**
     * Gets tickets where status EVALUATED or COMPLETED or FOR_REVISION
     * and matches ticket's field and matches department
     */
    @Query(value = """
            SELECT *
            FROM tickets t
            WHERE t.status in :statuses
                AND t.field = :field_id
                AND service in :services
            """, nativeQuery = true)
    List<Tickets> findTicketsByFieldsAndStatusesAndServices(@Param("field_id") Long field_id,
                                                            @Param("statuses") Iterable<Integer> statuses,
                                                            @Param("services") Iterable<Integer> services);

    /**
     * Gets tickets where status QUALITY_CHECKING
     * and matches ticket's field,
     * and he listed as quality controller
     */
    @Query(value = """
            SELECT t.*
            FROM tickets t
            LEFT JOIN tickets_quality_controllers tqc
                ON tqc.ticket_id = t.id
            LEFT JOIN users u
                ON tqc.quality_controller_id = u.id
            WHERE u.id = :id
                AND t.status = 8
                AND t.field = :field_id
            """, nativeQuery = true)
    List<Tickets> findQualityControlSpecialistTickets(@Param("id") Long id,
                                                      @Param("field_id") Long field_id);

    /**
     * Gets only its own tickets
     */
    @Query(value = """
            SELECT t.*
            FROM tickets t
            LEFT JOIN tickets_executors te
                ON te.ticket_id = t.id
            LEFT JOIN users u
                ON te.executor_id = u.id
            WHERE u.id = :id
                AND t.field = :field_id
            """, nativeQuery = true)
    List<Tickets> findTicketsByExecutorId(@Param("id") Long id, @Param("field_id") Long field_id);

    @Query(value = """
            SELECT t.*
            FROM tickets t
            LEFT JOIN tickets_quality_controllers tqc
                ON t.id = tqc.ticket_id
            LEFT JOIN tickets_executors te
                ON t.id = te.ticket_id
            WHERE te.executor_id = :id
                OR tqc.quality_controller_id = :id
                OR t.author = :id
                OR t.dispatcher = :id
                OR t.executors_nominator = :id
                OR t.quality_controllers_nominator = :id
            """, nativeQuery = true)
    List<Tickets> findTicketsHistory(@Param("id") Long id);

    @Query(value = """
            SELECT t.*
            FROM tickets_subscriptions ts
            LEFT JOIN tickets t
                ON t.id = ts.ticket_id
            WHERE user_id = :user_id
            """, nativeQuery = true)
    List<Tickets> findSubscribedTicketsByUserId(@Param("user_id") Long user_id);
}
