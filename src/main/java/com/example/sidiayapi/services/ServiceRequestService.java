package com.example.sidiayapi.services;

import com.example.sidiayapi.entities.ServiceRequest;
import com.example.sidiayapi.repositories.ServiceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRequestService {
    @Autowired
    ServiceRequestRepository serviceRequestRepository;

    public ResponseEntity<List<ServiceRequest>> get(int count) {
        List<ServiceRequest> serviceRequests = serviceRequestRepository.findAll();

        if (count < 1) {
            return new ResponseEntity<>(serviceRequests, HttpStatusCode.valueOf(200));
        } else {
            // Получение среза массива
            return new ResponseEntity<>(
                    serviceRequests.subList(0, Math.min(count, serviceRequests.size())),
                    HttpStatusCode.valueOf(200)
            );
        }
    }
}
