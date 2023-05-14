package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentsRepository extends JpaRepository<Departments, Long> {
}
