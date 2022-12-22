package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.ServiceRequestFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRequestFacilityRepository extends JpaRepository<ServiceRequestFacility, Long> {
}
