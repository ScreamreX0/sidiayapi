package com.example.sidiayapi.controllers.abstracts;

import com.example.sidiayapi.entities.ObjectEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IObjectsController {
    ResponseEntity<List<ObjectEntity>> get();
}
