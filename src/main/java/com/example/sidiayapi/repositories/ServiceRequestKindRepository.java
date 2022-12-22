package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.ServiceRequestKind;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRequestKindRepository extends JpaRepository<ServiceRequestKind, Long> {
}
