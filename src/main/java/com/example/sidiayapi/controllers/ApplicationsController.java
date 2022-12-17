package com.example.sidiayapi.controllers;

import com.example.sidiayapi.controllers.abstracts.IApplicationsController;
import com.example.sidiayapi.entities.ApplicationEntity;
import com.example.sidiayapi.entities.EmployeeEntity;
import com.example.sidiayapi.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/applications")
public class ApplicationsController implements IApplicationsController {
    @Autowired
    ApplicationService applicationService;

    /**
     * @HTTPStatus 200 -> application found
     * @HTTPStatus 400 -> application not found
     */
    @Override
    @GetMapping("/get-by-id")
    public ResponseEntity<ApplicationEntity> getById(@RequestBody Map<String, Object> body) {
        return applicationService.getApplicationById(body.get("id").toString());
    }

    /**
     * @HTTPStatus 200 -> applications found
     * @HTTPStatus 400 -> applications not found
     */
    @GetMapping("/get")
    @Override
    public ResponseEntity<List<ApplicationEntity>> get() {
        return applicationService.findAll();
    }

    /**
     * @HTTPStatus 200 -> added
     * @HTTPStatus 400 -> exception
     */
    @GetMapping("/add")
    @Override
    public ResponseEntity<String> add(@RequestBody Map<String, Object> body) {
        ApplicationEntity applicationEntity = new ApplicationEntity(
                (String) body.get("service"),
                (EmployeeEntity) body.get("executor"),
                (String) body.get("type"),
                (String) body.get("priority"),
                (String) body.get("status"),
                (Date) body.get("planned_date"),
                (Date) body.get("expiration_date"),
                (String) body.get("description"),
                (String) body.get("completed_works"),
                (EmployeeEntity) body.get("author"),
                (Date) body.get("creation_date"));

        return applicationService.addApplication(applicationEntity, (List<Object>) body.get("objects"));
    }
}
