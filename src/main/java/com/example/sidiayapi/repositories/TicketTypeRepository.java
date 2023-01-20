package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.TicketTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketTypeRepository extends JpaRepository<TicketTypes, Long> {
}
