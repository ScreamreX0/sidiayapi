package com.example.sidiayapi.services;

import com.example.sidiayapi.entities.EmployeeEntity;
import com.example.sidiayapi.repositories.EmployeeRepository;
import com.example.sidiayapi.services.abstracts.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public ResponseEntity<List<EmployeeEntity>> employees() {
        try {
            List<EmployeeEntity> employees = employeeRepository.findAll();

            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e) {
            Arrays.stream(e.getStackTrace()).forEach(System.out::println);
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
