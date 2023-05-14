package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.Materials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialsRepository extends JpaRepository<Materials, Long> {
}
