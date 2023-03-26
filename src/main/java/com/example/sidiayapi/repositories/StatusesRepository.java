package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.Facilities;
import com.example.sidiayapi.entities.Statuses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusesRepository extends JpaRepository<Statuses, Long> {
}
