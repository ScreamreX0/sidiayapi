package com.example.sidiayapi.services;

import com.example.sidiayapi.entities.Facility;
import com.example.sidiayapi.entities.ServiceRequestKind;
import com.example.sidiayapi.repositories.FacilityRepository;
import com.example.sidiayapi.repositories.ServiceRequestKindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRequestKindService {
    @Autowired
    ServiceRequestKindRepository serviceRequestKindRepository;

    public ResponseEntity<List<ServiceRequestKind>> get(int count) {
        List<ServiceRequestKind> serviceRequestKinds = serviceRequestKindRepository.findAll();

        if (count < 1) {
            return new ResponseEntity<>(serviceRequestKinds, HttpStatusCode.valueOf(200));
        } else {
            // Получение среза массива
            return new ResponseEntity<>(
                    serviceRequestKinds.subList(0, Math.min(count, serviceRequestKinds.size())),
                    HttpStatusCode.valueOf(200)
            );
        }
    }
}
