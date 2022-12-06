package com.example.sidiayapi.services.impl;

import com.example.sidiayapi.entities.ApplicationEntity;
import com.example.sidiayapi.entities.ApplicationsObjectsEntity;
import com.example.sidiayapi.repositories.ApplicationObjectsRepository;
import com.example.sidiayapi.repositories.ApplicationRepository;
import com.example.sidiayapi.services.abstracts.IApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ApplicationService implements IApplicationService {
    public ApplicationService() {
    }

    @Autowired
    ApplicationRepository applicationRepository;

    @Autowired
    ApplicationObjectsRepository applicationObjectsRepository;

    @Override
    public ResponseEntity<ApplicationEntity> getApplicationById(String id) {
        try {
            ApplicationEntity applicationEntity = applicationRepository.findApplicationById(id);

            if (applicationEntity == null) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>(applicationEntity, HttpStatus.OK);
        } catch (Exception e) {
            Arrays.stream(e.getStackTrace()).forEach(System.out::println);
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<List<ApplicationEntity>> findAll() {
        try {
            return new ResponseEntity<>(applicationRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            Arrays.stream(e.getStackTrace()).forEach(System.out::println);
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> addApplication(ApplicationEntity applicationEntity, List<Object> objects) {
        applicationRepository.save(applicationEntity);

        for (Object item : objects) {
            applicationObjectsRepository.save(new ApplicationsObjectsEntity(applicationEntity.getId(), Integer.parseInt((String) item)));
        }

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
