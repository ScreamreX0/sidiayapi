package com.example.sidiayapi.interfaces;

import com.example.sidiayapi.entities.ApplicationEntity;
import com.example.sidiayapi.entities.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IApplicationService {
    ResponseEntity<ApplicationEntity> getApplicationById(String id);

    ResponseEntity<List<ApplicationEntity>> getApplications();

    ResponseEntity<String> addApplication(ApplicationEntity applicationEntity);
}
