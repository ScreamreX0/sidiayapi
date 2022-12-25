package com.example.sidiayapi.services;

import com.example.sidiayapi.entities.ServiceRequestFacility;
import com.example.sidiayapi.repositories.ServiceRequestFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRequestFacilityService {
    @Autowired
    ServiceRequestFacilityRepository serviceRequestFacilityRepository;

    public ResponseEntity<List<ServiceRequestFacility>> get(int count) {
        List<ServiceRequestFacility> serviceRequestFacilities = serviceRequestFacilityRepository.findAll();

        if (count < 1) {
            return new ResponseEntity<>(serviceRequestFacilities, HttpStatusCode.valueOf(200));
        } else {
            // Получение среза массива
            return new ResponseEntity<>(
                    serviceRequestFacilities.subList(0, Math.min(count, serviceRequestFacilities.size())),
                    HttpStatusCode.valueOf(200)
            );
        }
    }
}
