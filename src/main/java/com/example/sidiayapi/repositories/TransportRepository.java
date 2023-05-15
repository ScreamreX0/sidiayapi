package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransportRepository extends JpaRepository<Transport, Long> {
    @Query(value = """
            SELECT *
            FROM transport t
            WHERE t.field_id = :field
            """, nativeQuery = true)
    List<Transport> findByField(@Param("field") Long field);
}
