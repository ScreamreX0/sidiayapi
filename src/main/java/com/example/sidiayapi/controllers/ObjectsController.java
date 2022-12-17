package com.example.sidiayapi.controllers;

import com.example.sidiayapi.controllers.abstracts.IObjectsController;
import com.example.sidiayapi.entities.ObjectEntity;
import com.example.sidiayapi.services.ObjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/objects")
public class ObjectsController implements IObjectsController {
    @Autowired
    ObjectsService objectsService;

    @GetMapping("/get")
    @Override
    public ResponseEntity<List<ObjectEntity>> get() {
        return objectsService.findAll();
    }
}
