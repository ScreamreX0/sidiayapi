package com.example.sidiayapi.services.abstracts;

import com.example.sidiayapi.entities.ApplicationEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IApplicationService {
    ResponseEntity<ApplicationEntity> getApplicationById(String id);

    ResponseEntity<List<ApplicationEntity>> findAll();

    ResponseEntity<String> addApplication(ApplicationEntity applicationEntity, List<Object> objects);
}
