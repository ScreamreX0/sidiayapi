package com.example.sidiayapi.controllers.users;

import com.example.sidiayapi.entities.Users;
import com.example.sidiayapi.models.SignInParams;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface IUsersController {
    ResponseEntity<String> test();
    ResponseEntity<Users> signIn(SignInParams signInParams, BindingResult bindingResult);
    ResponseEntity<List<Users>> get();
}
