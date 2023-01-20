package com.example.sidiayapi.services;

import com.example.sidiayapi.entities.Facilities;
import com.example.sidiayapi.repositories.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService {
    @Autowired
    FacilityRepository facilityRepository;

    public ResponseEntity<List<Facilities>> get(int count) {
        List<Facilities> facilities = facilityRepository.findAll();

        if (count < 1) {
            return new ResponseEntity<>(facilities, HttpStatusCode.valueOf(200));
        } else {
            // Получение среза массива
            return new ResponseEntity<>(
                    facilities.subList(0, Math.min(count, facilities.size())),
                    HttpStatusCode.valueOf(200)
            );
        }
    }
}
