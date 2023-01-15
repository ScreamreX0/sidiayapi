package com.example.sidiayapi.controllers.user;

import com.example.sidiayapi.entities.User;
import com.example.sidiayapi.models.SignInParams;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.Map;

public interface IUserController {
    ResponseEntity<String> test();
    ResponseEntity<User> signIn(SignInParams signInParams, BindingResult bindingResult);
}
