package com.example.sidiayapi.services;

import com.example.sidiayapi.entities.Facility;
import com.example.sidiayapi.entities.ServiceRequestState;
import com.example.sidiayapi.repositories.FacilityRepository;
import com.example.sidiayapi.repositories.ServiceRequestStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRequestStateService {
    @Autowired
    ServiceRequestStateRepository serviceRequestStateRepository;

    public ResponseEntity<List<ServiceRequestState>> get(int count) {
        List<ServiceRequestState> serviceRequestStates = serviceRequestStateRepository.findAll();

        if (count < 1) {
            return new ResponseEntity<>(serviceRequestStates, HttpStatusCode.valueOf(200));
        } else {
            // Получение среза массива
            return new ResponseEntity<>(
                    serviceRequestStates.subList(0, Math.min(count, serviceRequestStates.size())),
                    HttpStatusCode.valueOf(200)
            );
        }
    }
}
