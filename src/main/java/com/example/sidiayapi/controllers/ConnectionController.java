package com.example.sidiayapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ConnectionController {
    @GetMapping
    public ResponseEntity<Void> checkConnection() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
