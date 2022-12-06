package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.ObjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface ObjectsRepository extends JpaRepository<ObjectEntity, Long> {
}
