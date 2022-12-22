package com.example.sidiayapi.controllers;

import com.example.sidiayapi.entities.Field;
import com.example.sidiayapi.repositories.FieldRepository;
import com.example.sidiayapi.services.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/fields")
public class FieldController {

    @Autowired
    private FieldService fieldService;

    @GetMapping("/")
    private ResponseEntity<List<Field>> get() {
        return fieldService.get();
    }
}
