package com.example.sidiayapi.controllers;

import com.example.sidiayapi.entities.UserEntity;
import com.example.sidiayapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String test() {
        return "Hello world";
    }

    /**
     * @HTTPStatus 200 -> User found and authorized
     * @HTTPStatus 400 -> Wrong email or password
     * */
    @PostMapping("/email-in")
    public ResponseEntity<UserEntity> emailIn(@RequestBody Map<String, Object> body) {
        return userService.emailIn(
                body.get("email").toString(),
                body.get("password").toString());
    }
}
