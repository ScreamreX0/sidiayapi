package com.example.sidiayapi.controllers;

import com.example.sidiayapi.entities.ApplicationEntity;
import com.example.sidiayapi.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/applications")
public class ApplicationController {
    @Autowired
    ApplicationService applicationService;

    /**
     * @HTTPStatus 200 -> application found
     * @HTTPStatus 400 -> application not found
     * */
    @GetMapping("/get-by-id")
    public ResponseEntity<ApplicationEntity> getById(@RequestBody Map<String, Object> body) {
        return applicationService.getApplicationById(body.get("id").toString());
    }

    /**
     * @HTTPStatus 200 -> applications found
     * @HTTPStatus 400 -> applications not found
     * */
    @GetMapping("/get")
    public ResponseEntity<List<ApplicationEntity>> get() {
        return applicationService.getApplications();
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Map<String, Object> body) {
        return applicationService.addApplication(new ApplicationEntity(

        ));
    }
}
