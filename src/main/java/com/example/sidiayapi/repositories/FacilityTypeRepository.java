package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.FacilityTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityTypeRepository extends JpaRepository<FacilityTypes, Long> {
}
