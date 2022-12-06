package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.ApplicationsObjectsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationObjectsRepository extends JpaRepository<ApplicationsObjectsEntity, Long> {

}
