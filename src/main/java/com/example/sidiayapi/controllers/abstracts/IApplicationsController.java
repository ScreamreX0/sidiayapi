package com.example.sidiayapi.controllers.abstracts;

import com.example.sidiayapi.entities.ApplicationEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public interface IApplicationsController {
    ResponseEntity<ApplicationEntity> getById(@RequestBody Map<String, Object> body);

    ResponseEntity<List<ApplicationEntity>> get();

    ResponseEntity<String> add(@RequestBody Map<String, Object> body);
}
