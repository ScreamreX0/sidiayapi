package com.example.sidiayapi.services;

import com.example.sidiayapi.entities.ObjectEntity;
import com.example.sidiayapi.services.abstracts.IObjectsService;
import com.example.sidiayapi.repositories.ObjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectsService implements IObjectsService {
    @Autowired
    ObjectsRepository objectsRepository;

    @Override
    public ResponseEntity<List<ObjectEntity>> findAll() {
        return new ResponseEntity<>(objectsRepository.findAll(), HttpStatus.OK);
    }
}
