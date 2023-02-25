package com.example.sidiayapi.controllers;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class CheckController {
    @GetMapping("/")
    public ResponseEntity<String> check() {
        return new ResponseEntity<>("", HttpStatusCode.valueOf(200));
    }
}
