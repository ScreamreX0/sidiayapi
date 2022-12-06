package com.example.sidiayapi.services.abstracts;

import com.example.sidiayapi.entities.ObjectEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IObjectsService {
    ResponseEntity<List<ObjectEntity>> findAll();
}
