package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.Employees;
import com.example.sidiayapi.entities.Facilities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Long> {
}
