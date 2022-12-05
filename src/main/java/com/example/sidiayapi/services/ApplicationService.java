package com.example.sidiayapi.services;

import com.example.sidiayapi.entities.ApplicationEntity;
import com.example.sidiayapi.interfaces.IApplicationService;
import com.example.sidiayapi.repositories.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService implements IApplicationService {
    public ApplicationService() {
    }

    @Autowired
    ApplicationRepository applicationRepository;

    @Override
    public ResponseEntity<ApplicationEntity> getApplicationById(String id) {
        ApplicationEntity applicationEntity = applicationRepository.findApplicationById(id);

        if (applicationEntity == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(applicationEntity, HttpStatus.OK);
    }
}
