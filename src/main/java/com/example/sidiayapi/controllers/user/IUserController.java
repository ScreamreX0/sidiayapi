package com.example.sidiayapi.controllers.user;

import com.example.sidiayapi.entities.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IUserController {
    ResponseEntity<String> test();
    ResponseEntity<List<User>> get(Map<String, Object> params);
    ResponseEntity<List<User>> get(final int count);
}
