package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.ServiceRequestState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRequestStateRepository extends JpaRepository<ServiceRequestState, Long> {
}
