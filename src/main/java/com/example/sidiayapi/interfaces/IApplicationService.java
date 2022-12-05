package com.example.sidiayapi.interfaces;

import com.example.sidiayapi.entities.ApplicationEntity;
import com.example.sidiayapi.entities.UserEntity;
import org.springframework.http.ResponseEntity;

public interface IApplicationService {
    ResponseEntity<ApplicationEntity> getApplicationById(String id);
}
