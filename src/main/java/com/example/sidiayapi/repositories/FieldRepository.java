package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldRepository extends JpaRepository<Field, Long> {
}
