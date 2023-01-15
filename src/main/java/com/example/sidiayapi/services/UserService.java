package com.example.sidiayapi.services;

import com.example.sidiayapi.exceptions.ApiExceptions;
import com.example.sidiayapi.models.SignInParams;
import com.example.sidiayapi.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void signIn(SignInParams params) {
        throw new ApiExceptions.WrongEmailOrPasswordException();
    }
}
