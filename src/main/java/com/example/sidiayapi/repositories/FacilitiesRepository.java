package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.Facilities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacilitiesRepository extends JpaRepository<Facilities, Long> {
    @Query(value = """
            SELECT *
            FROM facilities f
            WHERE f.field_id = :field
            """, nativeQuery = true)
    List<Facilities> findByField(@Param("field") Long field);
}
