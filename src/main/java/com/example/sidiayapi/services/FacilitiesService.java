package com.example.sidiayapi.services;

import com.example.sidiayapi.entities.Facilities;
import com.example.sidiayapi.repositories.FacilitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilitiesService {
    @Autowired
    FacilitiesRepository facilitiesRepository;

    public ResponseEntity<List<Facilities>> get() {
        return new ResponseEntity<>(facilitiesRepository.findAll(), HttpStatusCode.valueOf(200));
    }
}
