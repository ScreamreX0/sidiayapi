package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.ServiceRequestKind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRequestKindRepository extends JpaRepository<ServiceRequestKind, Long> {
}
