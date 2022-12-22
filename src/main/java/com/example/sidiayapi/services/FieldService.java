package com.example.sidiayapi.services;

import com.example.sidiayapi.entities.Field;
import com.example.sidiayapi.repositories.FieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FieldService {
    @Autowired
    FieldRepository fieldRepository;

    public ResponseEntity<List<Field>> get() {
        return new ResponseEntity<>(fieldRepository.findAll(), HttpStatusCode.valueOf(200));
    }
}
