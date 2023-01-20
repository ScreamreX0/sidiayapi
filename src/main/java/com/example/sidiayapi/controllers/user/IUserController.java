package com.example.sidiayapi.controllers.user;

import com.example.sidiayapi.entities.Users;
import com.example.sidiayapi.models.SignInParams;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface IUserController {
    ResponseEntity<String> test();
    ResponseEntity<Users> signIn(SignInParams signInParams, BindingResult bindingResult);
}
