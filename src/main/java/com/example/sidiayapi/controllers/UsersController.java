package com.example.sidiayapi.controllers;

import com.example.sidiayapi.entities.Users;
import com.example.sidiayapi.models.Credentials;
import com.example.sidiayapi.services.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UsersController {
    UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<Users> signIn(@RequestBody Credentials credentials) {
        return new ResponseEntity<>(usersService.signIn(credentials), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Users> checkConnection() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
