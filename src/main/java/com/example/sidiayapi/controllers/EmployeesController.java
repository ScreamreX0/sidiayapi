package com.example.sidiayapi.controllers;

import com.example.sidiayapi.controllers.abstracts.IEmployeesController;
import com.example.sidiayapi.entities.EmployeeEntity;
import com.example.sidiayapi.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeesController implements IEmployeesController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/")
    @Override
    public ResponseEntity<List<EmployeeEntity>> employees(@RequestBody Map<String, Object> body) {
        return employeeService.employees();
    }
}
