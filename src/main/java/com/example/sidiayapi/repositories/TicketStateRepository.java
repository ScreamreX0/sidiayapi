package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.TicketState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketStateRepository extends JpaRepository<TicketState, Long> {
}
