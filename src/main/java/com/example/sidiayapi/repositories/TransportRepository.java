package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.Facilities;
import com.example.sidiayapi.entities.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportRepository extends JpaRepository<Transport, Long> {
}