package com.example.sidiayapi.repositories;

import com.example.sidiayapi.entities.ApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface ApplicationRepository extends JpaRepository<ApplicationEntity, Long> {
    @Query("FROM applications WHERE id = :id")
    ApplicationEntity findApplicationById(@Param("id") String id);
}
