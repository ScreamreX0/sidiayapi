package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.Subdivisions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubdivisionsRepository extends JpaRepository<Subdivisions, Long> {
}
