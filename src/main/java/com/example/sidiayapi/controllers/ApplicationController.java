package com.example.sidiayapi.controllers;

import com.example.sidiayapi.entities.ApplicationEntity;
import com.example.sidiayapi.entities.EmployeeEntity;
import com.example.sidiayapi.entities.ObjectEntity;
import com.example.sidiayapi.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.*;

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

    @GetMapping("/add")
    public ResponseEntity<String> add(@RequestBody Map<String, Object> body) {
        return applicationService.addApplication(new ApplicationEntity (
                (String)body.get("service"),
                (EmployeeEntity)body.get("executor"),
                (String)body.get("type"),
                (String)body.get("priority"),
                (String)body.get("status"),
                (Date)body.get("planned_date"),
                (Date)body.get("expiration_date"),
                (String)body.get("description"),
                (String)body.get("completed_works"),
                (EmployeeEntity)body.get("author"),
                (Date)body.get("creation_date")
        ), (List<Object>)body.get("objects"));
    }
}
