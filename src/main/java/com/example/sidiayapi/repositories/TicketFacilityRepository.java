package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.TicketFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketFacilityRepository extends JpaRepository<TicketFacility, Long> {
}
