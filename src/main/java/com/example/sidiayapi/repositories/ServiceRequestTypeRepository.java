package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.ServiceRequestType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRequestTypeRepository extends JpaRepository<ServiceRequestType, Long> {
}
