package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.TicketKind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketKindRepository extends JpaRepository<TicketKind, Long> {
}
