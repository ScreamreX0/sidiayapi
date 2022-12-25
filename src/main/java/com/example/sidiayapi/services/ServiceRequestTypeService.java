package com.example.sidiayapi.services;

import com.example.sidiayapi.entities.Facility;
import com.example.sidiayapi.entities.ServiceRequestType;
import com.example.sidiayapi.repositories.FacilityRepository;
import com.example.sidiayapi.repositories.ServiceRequestTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRequestTypeService {
    @Autowired
    ServiceRequestTypeRepository serviceRequestTypeRepository;

    public ResponseEntity<List<ServiceRequestType>> get(int count) {
        List<ServiceRequestType> serviceRequestTypes = serviceRequestTypeRepository.findAll();

        if (count < 1) {
            return new ResponseEntity<>(serviceRequestTypes, HttpStatusCode.valueOf(200));
        } else {
            // Получение среза массива
            return new ResponseEntity<>(
                    serviceRequestTypes.subList(0, Math.min(count, serviceRequestTypes.size())),
                    HttpStatusCode.valueOf(200)
            );
        }
    }
}
