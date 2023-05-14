package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.Sectors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorsRepository extends JpaRepository<Sectors, Long> {
}
