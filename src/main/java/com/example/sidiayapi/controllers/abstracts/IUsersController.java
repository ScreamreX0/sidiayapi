package com.example.sidiayapi.controllers.abstracts;

import com.example.sidiayapi.entities.EmployeeEntity;
import com.example.sidiayapi.entities.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public interface IUsersController {
    ResponseEntity<UserEntity> emailIn(@RequestBody Map<String, Object> body);

}
