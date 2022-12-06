package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.ApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface ApplicationRepository extends JpaRepository<ApplicationEntity, Long> {
    @Query("FROM applications WHERE id = :id")
    ApplicationEntity findApplicationById(@Param("id") String id);

    @Query("FROM applications")
    List<ApplicationEntity> findApplications();


}
