package com.example.sidiayapi.services;

import com.example.sidiayapi.entities.Fields;
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

    public ResponseEntity<List<Fields>> get(int count) {
        List<Fields> fields = fieldRepository.findAll();

        if (count < 1) {
            return new ResponseEntity<>(fields, HttpStatusCode.valueOf(200));
        } else {
            // Получение среза массива
            return new ResponseEntity<>(
                    fields.subList(0, Math.min(count, fields.size())),
                    HttpStatusCode.valueOf(200)
            );
        }
    }
}
