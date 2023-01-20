package com.example.sidiayapi.services;

import com.example.sidiayapi.entities.FacilityTypes;
import com.example.sidiayapi.repositories.FacilityTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeService {
    @Autowired
    FacilityTypeRepository facilityTypeRepository;

    public ResponseEntity<List<FacilityTypes>> get(int count) {
        List<FacilityTypes> facilityTypes = facilityTypeRepository.findAll();

        if (count < 1) {
            return new ResponseEntity<>(facilityTypes, HttpStatusCode.valueOf(200));
        } else {
            // Получение среза массива
            return new ResponseEntity<>(
                    facilityTypes.subList(0, Math.min(count, facilityTypes.size())),
                    HttpStatusCode.valueOf(200)
            );
        }
    }
}
