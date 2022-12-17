package com.example.sidiayapi.controllers.abstracts;

import com.example.sidiayapi.entities.EmployeeEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public interface IEmployeesController {
    ResponseEntity<List<EmployeeEntity>> employees(@RequestBody Map<String, Object> body);
}
