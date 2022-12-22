package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.ServiceRequestType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRequestTypeRepository extends JpaRepository<ServiceRequestType, Long> {
}
