package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.Kinds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface KindsRepository extends JpaRepository<Kinds, Long> {
}

