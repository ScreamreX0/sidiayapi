package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.TicketStates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketStateRepository extends JpaRepository<TicketStates, Long> {
}
