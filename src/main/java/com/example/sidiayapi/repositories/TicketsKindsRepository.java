package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.TicketKinds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketsKindsRepository extends JpaRepository<TicketKinds, Long> {
}
