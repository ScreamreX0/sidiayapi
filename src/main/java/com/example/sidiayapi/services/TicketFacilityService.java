package com.example.sidiayapi.services;

import com.example.sidiayapi.entities.TicketsFacilities;
import com.example.sidiayapi.repositories.TicketFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketFacilityService {
    @Autowired
    TicketFacilityRepository ticketFacilityRepository;

    public ResponseEntity<List<TicketsFacilities>> get(int count) {
        List<TicketsFacilities> serviceRequestFacilities = ticketFacilityRepository.findAll();

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
