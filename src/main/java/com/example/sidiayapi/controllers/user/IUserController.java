package com.example.sidiayapi.controllers.user;

import com.example.sidiayapi.entities.User;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface IUserController {
    ResponseEntity<String> test();
    ResponseEntity<User> signIn(Map<String, Object> signInParams);
}
