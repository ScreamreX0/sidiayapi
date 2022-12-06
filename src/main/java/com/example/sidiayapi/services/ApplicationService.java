package com.example.sidiayapi.services;

import com.example.sidiayapi.entities.ApplicationEntity;
import com.example.sidiayapi.interfaces.IApplicationService;
import com.example.sidiayapi.repositories.ApplicationRepository;
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

    @Override
    public ResponseEntity<ApplicationEntity> getApplicationById(String id) {
        try {
            ApplicationEntity applicationEntity = applicationRepository.findApplicationById(id);

            if (applicationEntity == null) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>(applicationEntity, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Exception" + Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<List<ApplicationEntity>> getApplications() {
        try {
            return new ResponseEntity<>(applicationRepository.findApplications(), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Exception" + Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> addApplication(ApplicationEntity applicationEntity) {
        try {

            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Exception:" + Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
