package com.example.sidiayapi.services.abstracts;

import com.example.sidiayapi.entities.EmployeeEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEmployeeService {
    ResponseEntity<List<EmployeeEntity>> employees();
}
