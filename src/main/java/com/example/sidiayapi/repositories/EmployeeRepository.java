package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.EmployeeEntity;
import com.example.sidiayapi.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@EnableJpaRepositories
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
